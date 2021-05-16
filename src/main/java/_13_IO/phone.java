package _13_IO;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class phone implements Externalizable {
    private static final long serialVersionUID = 1L;

    private String brand;
    private static String name = "苹果";  //static属性
    private transient int age;  //暂时的

    public phone(){}
    public phone(String brand, int age) {
        this.brand = brand;
        this.age = age;
    }

    @Override
    public String toString() {
        return "phone{" +
                "brand='" + brand + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        //out是对象输出流
        out.writeUTF(brand);
        out.writeUTF(name);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        brand = in.readUTF();
        name = in.readUTF();
        age = in.readInt();
    }
}
