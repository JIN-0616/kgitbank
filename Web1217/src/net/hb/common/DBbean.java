package net.hb.common;

public class DBbean {
  private int sabun;
  private String name;
  private String title;
  private java.util.Date nalja;
  private int pay ;
  private int rn, start, end;
  private int reply;
  
	public int getReply() { return reply;}
  public void setReply(int reply) { this.reply = reply;}
    
  public int getRn() {return rn;}
	public void setRn(int rn) {this.rn = rn;}
  public int getStart() {return start;}
  public void setStart(int start) {this.start = start;}
  public int getEnd() {return end;}
  public void setEnd(int end) {this.end = end;}
  
  public int getSabun() {	return sabun;	}
	public void setSabun(int sabun) {this.sabun = sabun;	}
	public String getName() {return name;	}
	public void setName(String name) {this.name = name;	}
	public String getTitle() {return title;	}
	public void setTitle(String title) {this.title = title;	}
	public java.util.Date getNalja() {return nalja;	}
	public void setNalja(java.util.Date nalja) {this.nalja = nalja;	}
	public int getPay() {return pay;}
	public void setPay(int pay) {this.pay = pay; }
  
  //페이징 행번호 rn, start, end
  //검색키워드 skey, sval
}
