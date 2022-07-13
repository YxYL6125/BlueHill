import javax.xml.crypto.Data;
import java.awt.*;
import java.util.Date;

/**
 * @program: BlueHill
 * @description: 子类
 * @author: YxYL
 * @create: 2022-07-12 21:09
 **/

public class CardLost extends Lost {

    private int uid;
    private Date registerTime;
    private String uInformation;



    public CardLost() {
    }

    public CardLost(int uid, Date registerTime, String uInformation) {
        this.uid = uid;
        this.registerTime = registerTime;
        this.uInformation = uInformation;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getuInformation() {
        return uInformation;
    }

    public void setuInformation(String uInformation) {
        this.uInformation = uInformation;
    }
}
