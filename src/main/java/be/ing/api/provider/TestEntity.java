package be.ing.api.provider;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test", schema = "shophopper")
public class TestEntity {

    @Column(name = "test_id")
    @Id
    private String testId;

    @Column(name = "test_name")
    private String testName;

    @Column(name = "test_description")
    private String testDesc;

    public String getTestId() {
        return testId;
    }

    public String getTestName() {
        return testName;
    }

    public String getTestDesc() {
        return testDesc;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public void setTestDesc(String testDesc) {
        this.testDesc = testDesc;
    }
}
