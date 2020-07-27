package com.random.dbo;

import javax.persistence.*;
import java.util.Date;

@Entity//Чтобы спринг понял, что мы хотим использовать этот класс как сущность
@Table(name = "random")
public class RandomNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//Генерация сквозных айди
    private Long id;
    private String nickname;
    private Date createDate;
    private int value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
