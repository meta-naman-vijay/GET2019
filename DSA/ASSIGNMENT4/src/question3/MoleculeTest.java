import static org.junit.Assert.*;
import org.junit.Test;
/**
 * @author naman
 * test class for OrganicMolecularMass class
 */
public class MoleculeTest {

    @Test
    public void test() {
        OrganicMolecularMass obj = new OrganicMolecularMass();
        String compound = "ch3";
        assertEquals(15, obj.evaluate(compound));
        compound = "CHOC(CH3)3";
        assertEquals(86, obj.evaluate(compound));
        compound = "C12H10";
        assertEquals(154, obj.evaluate(compound));
    }

    @Test(expected = NullPointerException.class)
    public void nulltest() {
        OrganicMolecularMass obj = new OrganicMolecularMass();
        assertEquals(15, obj.evaluate(null));
    }
}