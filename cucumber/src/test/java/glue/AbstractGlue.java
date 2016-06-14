package glue;


import org.springframework.test.context.ContextConfiguration;

/**
 * This class defines the base class for glue classes. It wires the spring configuration.
 */
@ContextConfiguration(locations = "classpath:context.xml")
public class AbstractGlue {
}