package serialization;

import java.io.Serializable;

public class User implements Serializable {
    //직렬화를 시키면 받는 쪽에서 이걸 객체로 다시 바꾸는건데, 이 버전을 잘 관리해줘야 한다
    //버전이 다르면 객체로 바뀌는 과정에서 문제가 생기므로..?
    private long id;
    private String name;
    private String password;

    @Override
    public String toString() {
        return ("id는 " + id + ", 이름은 " + name + ", 비밀번호는 " + password + "입니다.");
    }

    public User(long id, String name, String password){
        this.id = id;
        this.name = name;
        this.password = password;
    }
}
