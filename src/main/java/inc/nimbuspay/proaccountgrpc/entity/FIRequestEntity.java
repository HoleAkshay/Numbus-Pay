package inc.nimbuspay.proaccountgrpc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import proto.nimbuspay.financialinitiationv03.Document;

@Entity
@Table(name = "debug_log")
public class FIRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private Document request;
    
    public FIRequestEntity() {
    }
       
    public FIRequestEntity(Long id, Document request) {
        this.id = id;
        this.request = request;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Document getRequest() {
        return request;
    }

    public void setRequest(Document request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return "FIRequestEntity [id=" + id + ", request=" + request + "]";
    }

}
