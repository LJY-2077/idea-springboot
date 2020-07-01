package test;

/**
 * @author lijy
 * @descriptin
 * @since
 */
public enum Color {
    RED("01", "红色"),
    Blue("02", "蓝色"),
    Yellow("03", "黄色"),
    Pink("04","粉色");

    private Color(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private String code;
    private String desc;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    @Override
    public String toString() {
        return "Color{" +
                "编码='" + code + '\'' +
                ", 描述='" + desc + '\'' +
                '}';
    }
}
