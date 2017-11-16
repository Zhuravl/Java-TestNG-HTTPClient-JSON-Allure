package entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class describes core SOAP response entity
 */
@XmlRootElement(name = "Table")
@XmlAccessorType(XmlAccessType.FIELD)
public class Table {

    @XmlElement(name = "CITY")
    private String city;

    @XmlElement(name = "STATE")
    private String state;

    @XmlElement(name = "ZIP")
    private int zip;

    @XmlElement(name = "AREA_CODE")
    private int areaCode;

    @XmlElement(name = "TIME_ZONE")
    private String timeZone;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @Override
    public String toString() {
        return "Table{" +
                "city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", areaCode=" + areaCode +
                ", timeZone='" + timeZone + '\'' +
                '}';
    }
}
