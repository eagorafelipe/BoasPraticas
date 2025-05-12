package br.com.cabelo;

import br.com.cabelo.log.LogManager;
import br.com.cabelo.model.Nome;
import br.com.cabelo.model.Pessoa;
import br.com.cabelo.model.Senha;
import br.com.cabelo.model.contato.Email;
import br.com.cabelo.model.contato.email.Contato;
import br.com.cabelo.model.contato.endereco.Endereco;
import br.com.cabelo.model.contato.telefone.Telefone;
import br.com.cabelo.model.financeiro.InformacoesFinanceiras;
import br.com.cabelo.model.financeiro.Saldo;
import br.com.cabelo.service.NotificationService;
import br.com.cabelo.service.UserService;
import br.com.cabelo.util.ResultadoValidacao;
import br.com.cabelo.util.ValidacaoException;
import br.com.cabelo.util.Validacoes;
import br.com.cabelo.v1.container.Container;
import br.com.cabelo.v1.proxy.AOPProxy;
import org.slf4j.Logger;

import java.math.BigDecimal;
import java.util.Properties;

public class Main {

    private static final Logger log;
    private static Container container;

    static {
        initLog();
        log = LogManager.getLogger(Main.class);
    }

    public static void main(String[] args) {

        try {
            container = new Container(UserService.class, NotificationService.class);

            ResultadoValidacao<String> nome = Nome.validaNome("joaquim");
            ResultadoValidacao<String> sobrenome = Nome.validaSobrenome("sa");
            Nome iNome = new Nome(Validacoes.getValor(nome), Validacoes.getValor(sobrenome));

            ResultadoValidacao<String> senha = Senha.validaSenha("F31jAao!");
            Pessoa pessoa = new Pessoa(iNome, new Senha(Validacoes.getValor(senha)));

            log.debug("O nome: {} e a senha: {} são válidos!", pessoa.getNome(), pessoa.getSenha());

            UserService userService = AOPProxy.createProxy(container.getService(UserService.class), UserService.class);
            userService.registerUser(pessoa.getNome().getNome());

//        ResultadoValidacao<String> email = Email.validaEmail("joaquim@email.com");
//        Email iEmail = new Email(Validacoes.getValor(email));
            String email = Email.validaEmail2("joaquim@email.com");
//        Email iEmail = new Email(Validacoes.getValor(email));
            Email iEmail = new Email(email);

            ResultadoValidacao<String> celular = Telefone.validaCelular("11999999999");
            Contato contato = new Contato(new Endereco(), new Telefone(Validacoes.getValor(celular)), iEmail);
            log.debug("Contato: {}", contato);

            Saldo saldo = new Saldo();
            ResultadoValidacao<BigDecimal> atribuiSaldo = saldo.atribuirSaldo(BigDecimal.valueOf(10));
            Validacoes.valida(atribuiSaldo);
            InformacoesFinanceiras informacoesFinanceiras = new InformacoesFinanceiras(saldo);

            try {
                ResultadoValidacao<BigDecimal> adicionaSaldo = informacoesFinanceiras.getSaldo().adicionaSaldo(BigDecimal.valueOf(100));
                Validacoes.valida(adicionaSaldo);
            } catch (ValidacaoException e) {
                log.debug("O saldo atual: {}", informacoesFinanceiras.getSaldo().getSaldoTotal());
            }

            ResultadoValidacao<BigDecimal> removeSaldo = informacoesFinanceiras.getSaldo().removeSaldo(BigDecimal.valueOf(90));
            Validacoes.valida(removeSaldo);

        } catch (Exception e) {
            log.error("Erro: {}", (Object) e.getStackTrace());
        } finally {
            LogManager.getInstance().shutdown();
            if (container != null) container.clear();
        }
    }

    private static void initLog() {
        Properties props = new Properties();
        props.setProperty("log.level", "TRACE");
        props.setProperty("log.pattern", "%d{HH:mm:ss.SSS} %highlight(%-5level) [%10thread] %cyan(%-40logger{36}) - %msg%n");
        props.setProperty("log.file.path", "./logs/boas-praticas");
        props.setProperty("log.file.name", "boas-praticas.log");
        props.setProperty("log.file.maxSize", "10MB");
        props.setProperty("log.console", "true");

        LogManager.initialize(props);
    }
}