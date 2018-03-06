package www.evaluate.manage.bean;

/**
 * 类描述
 * 
 * @author trc
 * @version 1.0 2018年1月7日 改订
 * @since 1.0
 */
public class ResultMsg {

    private String state;
    private String message;
    private String data;
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    
}
