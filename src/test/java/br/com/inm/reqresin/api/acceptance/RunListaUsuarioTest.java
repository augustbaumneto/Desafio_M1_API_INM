package br.com.inm.reqresin.api.acceptance;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.IncludeTags;
//import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

//import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PUBLISH_QUIET_PROPERTY_NAME;


/**
 * 
 * Classe responsável pela execução dos testes da feature xxx
 * 
 * @author August Neto
 *
 */

@Suite
//Nome da suite para exibição
@SuiteDisplayName("Testes: API: Listar Usuarios")

//Motor Executor
@IncludeEngines("cucumber")

//Caminho das features
@SelectClasspathResource("features")

//Tags executadas
@IncludeTags("listar_usuarios")

//Configura para o Gherkin sair no console.
//@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")

//Configura para não exibir o quadro do cucumber no console
@ConfigurationParameter(key = PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true")
public class RunListaUsuarioTest {
}
