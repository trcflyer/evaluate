package www.evaluate.manage.pojo;

public class TbEvaluate {
	 private Integer id;

	    private Integer userid;

	    private Integer resid;

	    private Integer optionid;

	    private String res;

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public Integer getUserid() {
	        return userid;
	    }

	    public void setUserid(Integer userid) {
	        this.userid = userid;
	    }

	    public Integer getResid() {
	        return resid;
	    }

	    public void setResid(Integer resid) {
	        this.resid = resid;
	    }

	    public Integer getOptionid() {
	        return optionid;
	    }

	    public void setOptionid(Integer optionid) {
	        this.optionid = optionid;
	    }

	    public String getRes() {
	        return res;
	    }

	    public void setRes(String res) {
	        this.res = res == null ? null : res.trim();
	    }

}