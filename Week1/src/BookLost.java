/**
 * @program: BlueHill
 * @description: 子类
 * @author: YxYL
 * @create: 2022-07-12 21:09
 **/

public class BookLost extends Lost {

    private int price;
    private String name;
    private String writer;


    public BookLost() {
    }

    public BookLost(int price, String name, String writer) {
        this.price = price;
        this.name = name;
        this.writer = writer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
