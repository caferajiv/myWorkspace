package patterns.creational.prototype;

public abstract class Product implements Cloneable {
private String SKU;
private String description;
public Object clone() {
Object clone = null;
try {
clone = super.clone();
} catch (CloneNotSupportedException e) {
e.printStackTrace();
}
return clone;
}
public String getDescription() {
return description;
}
public String getSKU() {
return SKU;
}
public void setDescription(String string) {
description = string;
}
public void setSKU(String string) {
SKU = string;
}
}
