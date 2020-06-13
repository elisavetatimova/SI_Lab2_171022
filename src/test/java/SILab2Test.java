import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class SILab2Test {

    private SILab2 siLab2;

    @Before
    public void before() {
        siLab2 = new SILab2();
    }

    @Test
    public void test_function_shouldReturnSeconds_whenSingleAngleIsValid() {
        List<Integer> result = siLab2.function(anglesStub_validSingleAngle());

        //list size is 1
        assertThat(result.size(), is(equalTo(1)));
        assertThat(result.get(0), is(equalTo(435599)));
    }

    @Test
    public void test_function_shouldReturnSeconds_whenMultipleAnglesAreValid() {
        List<Integer> result = siLab2.function(anglesStub_validMultipleAngles());

        //list size is 1
        assertThat(result.size(), is(equalTo(2)));
        assertThat(result.get(0), is(equalTo(435599)));
        assertThat(result.get(1), is(equalTo(360610)));
    }

    @Test(expected = RuntimeException.class)
    public void test_function_shouldThrowRuntimeException_whenDegreesAreInvalid() {
        siLab2.function(anglesStub_invalidDegrees());
    }

    @Test(expected = RuntimeException.class)
    public void test_function_shouldThrowRuntimeException_whenMinutesAreInvalid() {
        siLab2.function(anglesStub_invalidMinutes());
    }

    @Test(expected = RuntimeException.class)
    public void test_function_shouldThrowRuntimeException_whenSecondsAreInvalid() {
        siLab2.function(anglesStub_invalidSeconds());
    }

    private static List<Angle> anglesStub_validSingleAngle() {
        List<Angle> angles = new ArrayList<>();
        angles.add(new Angle(120, 59, 59));
        return angles;
    }

    private static List<Angle> anglesStub_validMultipleAngles() {
        List<Angle> angles = new ArrayList<>();
        angles.add(new Angle(120, 59, 59));
        angles.add(new Angle(100, 10, 10));
        return angles;
    }

    private static List<Angle> anglesStub_invalidDegrees() {
        List<Angle> angles = new ArrayList<>();
        angles.add(new Angle(361, 59, 59));
        return angles;
    }

    private static List<Angle> anglesStub_invalidMinutes() {
        List<Angle> angles = new ArrayList<>();
        angles.add(new Angle(120, 60, 59));
        return angles;
    }

    private static List<Angle> anglesStub_invalidSeconds() {
        List<Angle> angles = new ArrayList<>();
        angles.add(new Angle(120, 50, 60));
        return angles;
    }
}
