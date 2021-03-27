package io.cucumber.danilo;

import io.cucumber.java.pt.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class validarCPFStep {
  public WebDriver browser;
  
  @Dado("que eu esteja na pagina de validacao de cpf")
  public void que_eu_esteja_na_pagina_de_validacao_de_cpf() {
    System.setProperty("webdriver.chrome.driver", "driver/chromedriver");

    browser = new ChromeDriver();
    browser.get("http://localhost:8081/");
  }

  @Dado("digito um cpf valido {string}")
  public void digito_um_cpf_valido(String string) {
    WebElement campoNome = browser.findElement(By.name("nome"));
    campoNome.sendKeys("Danilo");

    WebElement campoCpf = browser.findElement(By.name("cpf"));
    campoCpf.sendKeys(string);

  }

  @Quando("eu clico no botao enviar")
  public void eu_clico_no_botao_enviar() {
      WebElement campoCpf = browser.findElement(By.name("cpf"));
      campoCpf.submit();
  }

  @Entao("devo ver uma mensagem de {string}")
  public void devo_ver_uma_mensagem_de(String string) {
      String mensagem = browser.findElement(By.className("alert-success")).getText();
      assertEquals(mensagem , "Foi validado com sucesso");
      browser.quit();
  }
  @Dado("digito um cpf invalido {string}")
  public void digito_um_cpf_invalido(String string) {
    WebElement campoNome = browser.findElement(By.name("nome"));
    campoNome.sendKeys("Pedro");
    WebElement campoCpf = browser.findElement(By.name("cpf"));
    campoCpf.sendKeys(string);
  }

  @Quando("eu clico no botao enviar novamente")
  public void eu_clico_no_botao_enviar_novamente() {
      WebElement campoCpf = browser.findElement(By.name("cpf"));
      campoCpf.submit();
  }

  @Entao("devo ver uma nova mensagem de {string}")
  public void devo_ver_uma_nova_mensagem_de(String string) {
      String mensagem = browser.findElement(By.className("alert")).getText();
      assertEquals(string, mensagem);
      browser.quit();
    }
}
