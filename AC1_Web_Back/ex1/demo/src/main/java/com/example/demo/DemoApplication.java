package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.models.Cliente;
import com.example.demo.models.Produto;
import com.example.demo.models.Venda;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.repositories.ProdutoRepository;
import com.example.demo.repositories.VendaRepository;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public ApplicationRunner run(
            ProdutoRepository produtoRepo,
            ClienteRepository clienteRepo,
            VendaRepository vendaRepo
    ) {
        return args -> {
            Produto p1 = produtoRepo.save(new Produto(null, "Leite Integral", 33.50, "Laticínios", LocalDate.of(2025, 5, 10)));
            Produto p2 = produtoRepo.save(new Produto(null, "Queijo Mussarela", 45.00, "Laticínios", LocalDate.of(2025, 5, 20)));
            Produto p3 = produtoRepo.save(new Produto(null, "Iogurte Natural", 29.90, "Laticínios", LocalDate.of(2025, 4, 30)));
            Produto p4 = produtoRepo.save(new Produto(null, "Refrigerante Cola", 34.00, "Bebidas", LocalDate.of(2026, 1, 1)));
            Produto p5 = produtoRepo.save(new Produto(null, "Suco de Laranja", 38.00, "Bebidas", LocalDate.of(2025, 6, 15)));
            Produto p6 = produtoRepo.save(new Produto(null, "Cerveja Pilsen", 35.00, "Bebidas", LocalDate.of(2025, 7, 1)));
            Produto p7 = produtoRepo.save(new Produto(null, "Desodorante Spray", 27.00, "Higiene", LocalDate.of(2026, 2, 10)));
            Produto p8 = produtoRepo.save(new Produto(null, "Shampoo", 31.00, "Higiene", LocalDate.of(2026, 3, 15)));
            Produto p9 = produtoRepo.save(new Produto(null, "Condicionador", 32.50, "Higiene", LocalDate.of(2026, 4, 20)));
            Produto p10 = produtoRepo.save(new Produto(null, "Sabonete", 5.00, "Higiene", LocalDate.of(2025, 9, 10)));
            Produto p11 = produtoRepo.save(new Produto(null, "Água Mineral", 3.50, "Bebidas", LocalDate.of(2025, 8, 1)));
            Produto p12 = produtoRepo.save(new Produto(null, "Achocolatado", 34.90, "Laticínios", LocalDate.of(2025, 5, 22)));
            Produto p13 = produtoRepo.save(new Produto(null, "Manteiga", 36.00, "Laticínios", LocalDate.of(2025, 6, 12)));
            Produto p14 = produtoRepo.save(new Produto(null, "Café Solúvel", 28.00, "Bebidas", LocalDate.of(2026, 1, 5)));
            Produto p15 = produtoRepo.save(new Produto(null, "Álcool Gel", 15.00, "Higiene", LocalDate.of(2026, 7, 30)));

            Cliente c1 = clienteRepo.save(new Cliente(null, "111.111.111-11", "11999990001"));
            Cliente c2 = clienteRepo.save(new Cliente(null, "222.222.222-22", "11999990002"));
            Cliente c3 = clienteRepo.save(new Cliente(null, "333.333.333-33", "11999990003"));
            Cliente c4 = clienteRepo.save(new Cliente(null, "444.444.444-44", "11999990004"));
            Cliente c5 = clienteRepo.save(new Cliente(null, "555.555.555-55", "11999990005"));
            Cliente c6 = clienteRepo.save(new Cliente(null, "666.666.666-66", "11999990006"));
            Cliente c7 = clienteRepo.save(new Cliente(null, "777.777.777-77", "11999990007"));
            Cliente c8 = clienteRepo.save(new Cliente(null, "888.888.888-88", "11999990008"));
            Cliente c9 = clienteRepo.save(new Cliente(null, "999.999.999-99", "11999990009"));
            Cliente c10 = clienteRepo.save(new Cliente(null, "000.000.000-00", "11999990010"));

            Cliente jose = clienteRepo.save(new Cliente(null, "123.456.789-00", "11987654321"));

            vendaRepo.save(new Venda(null, jose.getId(), p1.getId(), p1.getDescricao(), 2, p1.getPreco(), 2 * p1.getPreco(), LocalDateTime.of(2025, 1, 10, 14, 30)));
            vendaRepo.save(new Venda(null, jose.getId(), p2.getId(), p2.getDescricao(), 3, p2.getPreco(), 3 * p2.getPreco(), LocalDateTime.of(2025, 2, 5, 16, 45)));
            vendaRepo.save(new Venda(null, jose.getId(), p3.getId(), p3.getDescricao(), 10, p3.getPreco(), 10 * p3.getPreco(), LocalDateTime.of(2025, 3, 20, 10, 0)));

            vendaRepo.save(new Venda(null, c2.getId(), p4.getId(), p4.getDescricao(), 5, p4.getPreco(), 5 * p4.getPreco(), LocalDateTime.of(2025, 4, 1, 9, 0)));
            vendaRepo.save(new Venda(null, c3.getId(), p5.getId(), p5.getDescricao(), 2, p5.getPreco(), 2 * p5.getPreco(), LocalDateTime.of(2025, 2, 20, 11, 0)));
            vendaRepo.save(new Venda(null, c4.getId(), p6.getId(), p6.getDescricao(), 6, p6.getPreco(), 6 * p6.getPreco(), LocalDateTime.of(2025, 1, 25, 15, 30)));
            vendaRepo.save(new Venda(null, c5.getId(), p7.getId(), p7.getDescricao(), 20, p7.getPreco(), 20 * p7.getPreco(), LocalDateTime.of(2025, 2, 1, 13, 15)));
            vendaRepo.save(new Venda(null, c6.getId(), p8.getId(), p8.getDescricao(), 50, p8.getPreco(), 50 * p8.getPreco(), LocalDateTime.of(2025, 3, 5, 18, 20)));

            System.out.println("-----------------------------------------------------------------");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("-----------------------------------------------------------------");

            System.out.println("1 ------------- Produtos com preço > R$ 32,00: -------------");
            produtoRepo.findByPrecoGreaterThan(32.0).forEach(System.out::println);

            System.out.println("-----------------------------------------------------------------");

            System.out.println("2 ------------- Produtos do setor Laticínios: -------------");
            produtoRepo.findBySetorIgnoreCase("Laticínios").forEach(System.out::println);

            System.out.println("-----------------------------------------------------------------");

            System.out.println("3 ------------- Produtos com validade após 18/04/2025: -------------");
            produtoRepo.findByValidadeAfter(LocalDate.of(2025, 4, 18)).forEach(System.out::println);

            System.out.println("-----------------------------------------------------------------");

            System.out.println("4 ------------- Cliente por CPF: -------------");
            clienteRepo.findByCpf("123.456.789-00").ifPresent(System.out::println);

            System.out.println("-----------------------------------------------------------------");

            System.out.println("5 ------------- Cliente por celular: -------------");
            clienteRepo.findByCelular("11987654321").ifPresent(System.out::println);

            System.out.println("-----------------------------------------------------------------");

            System.out.println("6 ------------- Vendas do cliente José Antônio Souza e Cruz: -------------");
            vendaRepo.findByClienteId(jose.getId()).forEach(System.out::println);

            System.out.println("-----------------------------------------------------------------");

            System.out.println("7 ------------- Vendas com valor total > R$ 1528,32: -------------");
            vendaRepo.findByValorTotalGreaterThan(1528.32).forEach(System.out::println);

            System.out.println("-----------------------------------------------------------------");

            System.out.println("8 ------------- Vendas entre 01/01/2025 e 31/03/2025: -------------");
            vendaRepo.findByDataVendaBetween(
                    LocalDateTime.of(2025, 1, 1, 0, 0),
                    LocalDateTime.of(2025, 3, 31, 23, 59)
            ).forEach(System.out::println);

            System.out.println("-----------------------------------------------------------------");

            System.out.println("9 ------------- Vendas com produtoId = " + p2.getId() + ": -------------");
            vendaRepo.findByProdutoId(p2.getId()).forEach(System.out::println);
            
            System.out.println("-----------------------------------------------------------------");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("-----------------------------------------------------------------");

        };
    }

}
