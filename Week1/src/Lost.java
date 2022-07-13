import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: BlueHill
 * @description: 父类Lost
 * @author: YxYL
 * @create: 2022-07-12 21:09
 **/

public abstract class Lost {
    private Data getTime;
    private Date lostTime;
    private String user;
    private String location;

    @Override
    public String toString() {
        return "Lost{" +
                "getTime=" + getTime +
                ", lostTime=" + lostTime +
                ", user='" + user + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public Data getGetTime() {
        return getTime;
    }

    public void setGetTime(Data getTime) {
        this.getTime = getTime;
    }

    public Date getLostTime() {
        return lostTime;
    }

    public void setLostTime(Date lostTime) {
        this.lostTime = lostTime;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
