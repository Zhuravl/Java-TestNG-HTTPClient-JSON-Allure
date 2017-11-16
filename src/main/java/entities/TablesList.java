package entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Class describes main SOAP response entity
 */
@XmlRootElement(name = "NewDataSet")
@XmlAccessorType(XmlAccessType.FIELD)
public class TablesList {

    @XmlElement(name = "Table")
    private List<Table> tables = null;

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    @Override
    public String toString() {
        return "TablesList{" +
                "tables=" + tables +
                '}';
    }
}
