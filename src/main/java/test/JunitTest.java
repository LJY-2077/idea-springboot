package test;

/**
 * @author lijy
 * @descriptin
 * @since
 */
public class JunitTest {

    private  String name;
    private  String depcode;

    public JunitTest(String name, String depcode) {
        this.name = name;
        this.depcode = depcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepcode() {
        return depcode;
    }

    public void setDepcode(String depcode) {
        this.depcode = depcode;
    }

    public String concateResult(JunitTest test){
        return "员工编号："+test.depcode+"员工姓名："+test.name;

    }
}
