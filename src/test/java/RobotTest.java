import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class RobotTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private static Robot robot = new Robot("test");;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @ParameterizedTest
    @MethodSource("provideRobotCommandExpect")
    public void testMain(Robot.Command command, String expect) {
        //when
        robot.order(command);

        //then
        Assertions.assertEquals(expect, outputStreamCaptor.toString());
    }


    private static Stream<Arguments> provideRobotCommandExpect() {
        return Stream.of(
                arguments(Robot.Command.WALK, robot.getName() + " walks.\n"),
                arguments(Robot.Command.STOP, robot.getName() + " stops.\n"),
                arguments(Robot.Command.JUMP, robot.getName() + " jumps.\n")
        );
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
