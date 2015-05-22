
package org.anderes.edu.employee.application.boundary.rest;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import org.anderes.edu.employee.application.EmployeeFacade;
import org.anderes.edu.employee.application.DevMock;
import org.anderes.edu.employee.application.DevMocks;
import org.anderes.edu.employee.application.boundary.DtoMapper;
import org.anderes.edu.employee.application.boundary.DtoMapperCopy;
import org.anderes.edu.employee.application.boundary.dto.AddressDto;
import org.anderes.edu.employee.application.boundary.dto.EmployeeDto;
import org.anderes.edu.employee.application.boundary.dto.EmployeesDto;
import org.anderes.edu.employee.application.boundary.dto.Links.Link;
import org.anderes.edu.employee.application.boundary.dto.ProjectsDto;
import org.anderes.edu.employee.domain.Employee;
import org.anderes.edu.employee.domain.logger.LoggerProducer;
import org.anderes.edu.employee.persistence.EntityManagerProducer;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.descriptor.api.Descriptors;
import org.jboss.shrinkwrap.descriptor.api.beans11.BeansDescriptor;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.PomEquippedResolveStage;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Dieser Test zeitg auf wie man Arqillian und Mockito kombinieren kann.<br>
 * In diesem Beispiel wird das Data-Repository (welches mittels {@code @Inject} eingebunden wird)
 * durch eine Mock-Klasse ersetzt werden kann.
 * 
 * @author René Anderes
 *
 */
@RunWith(Arquillian.class) 
public class EmployeeResourceMockIT {
	
    private static final String REST = "rest";
    private static final String EMPLOYEES = "employees";
    
    @Deployment(name = "test")
    public static WebArchive createDeployment() {
        PomEquippedResolveStage pom = Maven.resolver().loadPomFromFile("pom.xml"); 
        BeansDescriptor beansXml = Descriptors.create(BeansDescriptor.class)
                        .addDefaultNamespaces().beanDiscoveryMode("all")
                        .getOrCreateAlternatives().stereotype(DevMock.class.getName()).up();
        return ShrinkWrap
            .create(WebArchive.class)
            // Application-Layer
            .addClasses(EmployeeFacade.class, EmployeeApplication.class, EmployeeResource.class)
            // DTO's
            .addPackage(EmployeeDto.class.getPackage())
            .addClasses(DtoMapper.class, DtoMapperCopy.class)
            // Domain-Layer-Klassen
            .addPackage(Employee.class.getPackage())
            // EntityManager-Producer
            .addClass(EntityManagerProducer.class)
            .addClasses(DevMock.class, DevMocks.class)
            // Logger Producer
            .addClass(LoggerProducer.class)
            // Resourcen
            .addAsResource(new File("target/test-classes/META-INF/derby-persistence.xml"), "META-INF/persistence.xml")
//            .addAsResource(new File("target/test-classes/META-INF/beans.xml"), "META-INF/beans.xml")
//            .addAsManifestResource(new File("target/test-classes/META-INF/beans.xml"), "beans.xml")
//            .addAsWebInfResource(new File("target/test-classes/META-INF/beans.xml"), "beans.xml")
            .addAsWebInfResource(new StringAsset(beansXml.exportAsString()), beansXml.getDescriptorName())
            .addAsLibraries(pom.resolve("org.mockito:mockito-core").withTransitivity().asFile());
    }

//    @Deployment(name = "test")
    public static JavaArchive createDeploymentJar() {
        return ShrinkWrap
            .create(JavaArchive.class, "test.jar")
            // Application-Layer
            .addClasses(EmployeeFacade.class, EmployeeApplication.class, EmployeeResource.class)
            // DTO's
            .addPackage(EmployeeDto.class.getPackage())
            .addClasses(DtoMapper.class, DtoMapperCopy.class)
            // Domain-Layer-Klassen
            .addPackage(Employee.class.getPackage())
            // EntityManager-Producer
            .addClass(EntityManagerProducer.class)
            .addClasses(DevMock.class, DevMocks.class)
            // Logger Producer
            .addClass(LoggerProducer.class)
            // Resourcen
            .addAsManifestResource(new File("target/test-classes/META-INF/derby-persistence.xml"), "persistence.xml")
            .addAsManifestResource(new File("target/test-classes/META-INF/beans.xml"), "beans.xml");
    }
    
    @Test
    @RunAsClient
    public void shouldBeFindOne(@ArquillianResource URL deploymentUrl) throws Exception {
                
    	// given
    	final UriBuilder uri = createUriFromDeploymentPath(deploymentUrl).path("70");
    	final WebTarget target = ClientBuilder.newClient().target(uri).register(JacksonFeature.class);
    	
    	// when
    	final Response response = target.request(APPLICATION_JSON_TYPE).buildGet().invoke();
    	
    	// then
    	assertThat(response.getStatus(), is(Status.OK.getStatusCode()));
    	assertThat(response.hasEntity(), is(true));
    	final EmployeeDto employee = response.readEntity(EmployeeDto.class);
    	assertThat(employee, is(notNullValue()));
    	assertThat(employee.getFirstname(), is("John"));
    	assertThat(employee.getLastname(), is("Way"));
    	assertThat(employee.getJobtitle(), is("Manager"));
    	assertThat(employee.getSalary(), is(BigDecimal.valueOf(53005)));
    	assertThat(employee.getGender(), is("Male"));
    	assertThat(employee.getLinks().getLink().size(), is(2));
    	Link link = employee.getLinks().getLink().get(0);
    	assertThat(link.getRel(), is("address"));
    	assertThat(link.getUrl(), is(getResourcesPathAsString(deploymentUrl) + employee.getId() + "/address"));
    	link = employee.getLinks().getLink().get(1);
        assertThat(link.getRel(), is("projects"));
        assertThat(link.getUrl(), is(getResourcesPathAsString(deploymentUrl) + employee.getId() + "/projects"));
    }
    
    @Test
    @RunAsClient
    public void shouldBeFindAddress(@ArquillianResource URL deploymentUrl) throws Exception {
        // given
        final UriBuilder uri = createUriFromDeploymentPath(deploymentUrl).path("70").path("/address");
        final WebTarget target = ClientBuilder.newClient().target(uri).register(JacksonFeature.class);
        
        // when
        final Response response = target.request(APPLICATION_JSON_TYPE).buildGet().invoke();
        
        // then
        assertThat(response.getStatus(), is(Status.OK.getStatusCode()));
        assertThat(response.hasEntity(), is(true));
        final AddressDto address = response.readEntity(AddressDto.class);
        assertThat(address, is(notNullValue()));
        assertThat(address.getCity(), is("Perth"));
        assertThat(address.getCountry(), is("Canada"));
        assertThat(address.getStreet(), is("234 Caledonia Lane"));
        assertThat(address.getProvince(), is("ONT"));
        assertThat(address.getPostalCode(), is("Y3Q2N9"));
    }
    
    @Test
    @RunAsClient
    public void shouldBeFindProjects(@ArquillianResource URL deploymentUrl) throws Exception {
        // given
        final UriBuilder uri = createUriFromDeploymentPath(deploymentUrl).path("70").path("/projects");
        final WebTarget target = ClientBuilder.newClient().target(uri).register(JacksonFeature.class);
        
        // when
        final Response response = target.request(APPLICATION_JSON_TYPE).buildGet().invoke();
        
        // then
        assertThat(response.getStatus(), is(Status.OK.getStatusCode()));
        assertThat(response.hasEntity(), is(true));
        final ProjectsDto projectsDto = response.readEntity(ProjectsDto.class);
        assertThat(projectsDto.getProject().size(), is(2));
    }
    
    @Test
    @RunAsClient
    public void shouldBeNotFindOne(@ArquillianResource URL deploymentUrl) throws Exception {
    	// given
    	final UriBuilder uri = createUriFromDeploymentPath(deploymentUrl).path("1007");
    	final WebTarget target = ClientBuilder.newClient().target(uri).register(JacksonFeature.class);
    	
    	// when
    	final Response response = target.request(APPLICATION_JSON_TYPE).buildGet().invoke();

    	// then
    	assertThat(response.getStatus(), is(Status.NOT_FOUND.getStatusCode()));
    }
    
    @Test
    @RunAsClient
    public void shouldBeWrongUrl(@ArquillianResource URL deploymentUrl) throws Exception {
    	// given
    	final UriBuilder uri = createUriFromDeploymentPath(deploymentUrl).path("A70");
    	final WebTarget target = ClientBuilder.newClient().target(uri).register(JacksonFeature.class);
    	
    	// when
    	final Response response = target.request(APPLICATION_JSON_TYPE).buildGet().invoke();

    	// then
    	assertThat(response.getStatus(), is(Status.NOT_FOUND.getStatusCode()));
    }
    
    @Test
    @RunAsClient
    public void shouldBeFindBySalary(@ArquillianResource URL deploymentUrl) throws Exception {
    	// given
    	final UriBuilder uri = createUriFromDeploymentPath(deploymentUrl).queryParam("salary", 45000D);
    	final WebTarget target = ClientBuilder.newClient().target(uri).register(JacksonFeature.class);
    	
    	// when
    	final Response response = target.request(APPLICATION_JSON_TYPE).buildGet().invoke();

    	// then
    	assertThat(response.getStatus(), is(Status.OK.getStatusCode()));
    	assertThat(response.hasEntity(), is(true));
		final EmployeesDto employees = response.readEntity(EmployeesDto.class);
    	assertThat(employees.getEmployee().size(), is(9));
    	for (EmployeesDto.Employee employee : employees.getEmployee()) {
            assertThat(employee.getLinks().getLink().size(), is(1));
            final Link link = employee.getLinks().getLink().get(0);
            assertThat(link.getRel(), is("employee"));
            assertThat(link.getUrl().matches(getResourcesPathAsString(deploymentUrl) + "[0-9]{2,2}"), is(true));
        }
    }

    private String getResourcesPathAsString(URL deploymentUrl) throws MalformedURLException {
        final UriBuilder expectedUri = createUriFromDeploymentPath(deploymentUrl);
        return expectedUri.build().toURL().toString() + "/";
    }
    
    @Test
    @RunAsClient
    public void shouldBeFindEmployees(@ArquillianResource URL deploymentUrl) throws Exception {
        // given
        final UriBuilder uri = createUriFromDeploymentPath(deploymentUrl);
        final WebTarget target = ClientBuilder.newClient().target(uri).register(JacksonFeature.class);
        
        // when
        final Response response = target.request(APPLICATION_JSON_TYPE).buildGet().invoke();

        // then
        assertThat(response.getStatus(), is(Status.OK.getStatusCode()));
        assertThat(response.hasEntity(), is(true));
        final EmployeesDto employees = response.readEntity(EmployeesDto.class);
        assertThat(employees.getEmployee().size(), is(12));
        for (EmployeesDto.Employee employee : employees.getEmployee()) {
            assertThat(employee.getLinks().getLink().size(), is(1));
            final Link link = employee.getLinks().getLink().get(0);
            assertThat(link.getRel(), is("employee"));
            assertThat(link.getUrl().matches(getResourcesPathAsString(deploymentUrl) + "[0-9]{2,2}"), is(true));
        }
    }
    
    private UriBuilder createUriFromDeploymentPath(final URL deploymentUrl) {
    	return UriBuilder.fromPath(getResourcePath(deploymentUrl).toString()).
  	                scheme(deploymentUrl.getProtocol()).host(deploymentUrl.getHost()).port(deploymentUrl.getPort());
    }
    
    private URI getResourcePath(final URL deploymentUrl) {
        return UriBuilder.fromPath(deploymentUrl.getPath()).path(REST).path(EMPLOYEES).build();
        
    }
}
