const api = "http://localhost:8080/api";
let editandoCliente = false;
let clienteIdEditando = null;

// CLIENTE
function cadastrarCliente() {
  const cliente = {
    nome: document.getElementById("nome").value,
    cpf: document.getElementById("cpf").value,
    telefone: document.getElementById("telefone").value,
  };

  const url = editandoCliente
    ? `${api}/clientes/${clienteIdEditando}`
    : `${api}/clientes`;

  const method = editandoCliente ? "PUT" : "POST";

  fetch(url, {
    method,
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(cliente),
  }).then(() => {
    alert(editandoCliente ? "Cliente atualizado!" : "Cliente cadastrado!");
    listarTodos();
    resetarFormularioCliente();
  });
}


// QUARTO
function atualizarCamposTipo() {
  const tipo = document.getElementById("tipoQuarto").value;
  document.getElementById("campos-normal").style.display =
    tipo === "normal" ? "block" : "none";
  document.getElementById("campos-vip").style.display =
    tipo === "vip" ? "block" : "none";
}

function cadastrarQuarto() {
  const tipo = document.getElementById("tipoQuarto").value;
  const url = tipo === "vip" ? `${api}/quartos/vip` : `${api}/quartos/normal`;

  const quartoBase = {
    numero: document.getElementById("numero").value,
    precoPorNoite: parseFloat(document.getElementById("preco").value),
    disponivel: document.getElementById("disponivel").checked,
  };

  const quarto =
    tipo === "vip"
      ? {
          ...quartoBase,
          arCondicionado: document.getElementById("arCondicionado").checked,
          hidromassagem: document.getElementById("hidromassagem").checked,
        }
      : {
          ...quartoBase,
          ventilador: document.getElementById("ventilador").checked,
        };

  fetch(url, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(quarto),
  }).then(() => {
    alert("Quarto cadastrado!");
    listarTodos();
  });
}

// RESERVA
function fazerReserva() {
  const reserva = {
    clienteId: parseInt(document.getElementById("clienteId").value),
    quartoId: parseInt(document.getElementById("quartoId").value),
    dataEntrada: document.getElementById("entrada").value,
    dataSaida: document.getElementById("saida").value,
  };

  fetch(`${api}/reservas`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(reserva),
  }).then((res) => {
    if (res.ok) {
      alert("Reserva realizada!");
      listarTodos();
    } else {
      res.text().then((txt) => alert("Erro: " + txt));
    }
  });
}

// LISTAGEM GERAL
function listarTodos() {
  // CLIENTES
  fetch(`${api}/clientes`)
    .then((res) => res.json())
    .then((data) => {
      const tbody = document.querySelector("#tabela-clientes tbody");
      tbody.innerHTML = "";
      data.forEach((c) => {
        tbody.innerHTML += `<tr>
          <td>${c.id}</td>
          <td>${c.nome}</td>
          <td>${c.cpf}</td>
          <td>${c.telefone}</td>
          <td>
            <button class="btn btn-sm btn-warning" onclick="prepararEdicaoCliente(${c.id}, '${c.nome}', '${c.cpf}', '${c.telefone}')">Editar</button>
          </td>
        </tr>`;
      });
    });

  // QUARTOS
  fetch(`${api}/quartos`)
    .then((res) => res.json())
    .then((data) => {
      const tbody = document.querySelector("#tabela-quartos tbody");
      tbody.innerHTML = "";
      data.forEach((q) => {
        tbody.innerHTML += `<tr>
          <td>${q.id}</td>
          <td>${q.numero}</td>
          <td>R$ ${q.precoPorNoite.toFixed(2)}</td>
          <td>${q.tipo_quarto || "-"}</td>
          <td>${q.ventilador ?? "-"}</td>
          <td>${q.arCondicionado ?? "-"}</td>
          <td>${q.hidromassagem ?? "-"}</td>
          <td>${q.disponivel ? "Sim" : "Não"}</td>
        </tr>`;
      });
    });

  // RESERVAS
  fetch(`${api}/reservas`)
    .then((res) => res.json())
    .then((data) => {
      const tbody = document.querySelector("#tabela-reservas tbody");
      tbody.innerHTML = "";
      data.forEach((r) => {
        tbody.innerHTML += `<tr>
          <td>${r.id}</td>
          <td>${r.cliente.nome}</td>
          <td>${r.quarto.numero}</td>
          <td>${r.dataEntrada}</td>
          <td>${r.dataSaida}</td>
          <td>R$ ${r.valorTotal?.toFixed(2)}</td>
        </tr>`;
      });
    });
}

// Ao carregar a página
window.onload = listarTodos;

function resetarFormularioCliente() {
  document.getElementById("nome").value = "";
  document.getElementById("cpf").value = "";
  document.getElementById("telefone").value = "";

  editandoCliente = false;
  clienteIdEditando = null;

  const btn = document.querySelector("button[onclick='cadastrarCliente()']");
  btn.textContent = "Salvar Cliente";
  btn.classList.remove("btn-warning");
  btn.classList.add("btn-primary");
}

function prepararEdicaoCliente(id, nome, cpf, telefone) {
  document.getElementById("nome").value = nome;
  document.getElementById("cpf").value = cpf;
  document.getElementById("telefone").value = telefone;

  editandoCliente = true;
  clienteIdEditando = id;

  const btn = document.querySelector("button[onclick='cadastrarCliente()']");
  btn.textContent = "Atualizar Cliente";
  btn.classList.remove("btn-primary");
  btn.classList.add("btn-warning");
}
