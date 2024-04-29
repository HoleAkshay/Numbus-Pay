package inc.nimbuspay.proaccountgrpc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import inc.nimbuspay.proaccountgrpc.entity.FIRequestEntity;
import inc.nimbuspay.proaccountgrpc.service.FIRequestEntityService;
import io.grpc.stub.StreamObserver;
import proto.nimbuspay.AcquirerToIssuerCardTransactionsServiceGrpc.AcquirerToIssuerCardTransactionsServiceImplBase;
import proto.nimbuspay.financialinitiationv03.Document;
import proto.nimbuspay.financialresponsev03.FinancialResponse2;
import proto.nimbuspay.financialresponsev03.FinancialResponseV03;
import proto.nimbuspay.financialresponsev03.ProcessingResult10;
import proto.nimbuspay.financialresponsev03.ResultData7;

@Component
public class AcquirerToIssuerCardTransactionsServiceController extends AcquirerToIssuerCardTransactionsServiceImplBase {

    @Autowired
    private FIRequestEntityService fiRequestEntityService;
    
    // for to check the controller working 
    @Override
    public StreamObserver<Document> financial(
            StreamObserver<proto.nimbuspay.financialresponsev03.Document> responseObserver) {
        return new StreamObserver<Document>() {

            @Override
            public void onNext(Document request) {
                FIRequestEntity fiRequestEntity = new FIRequestEntity();
                fiRequestEntity.setRequest(request);

                fiRequestEntityService.saveFIRequest(fiRequestEntity);
                proto.nimbuspay.financialresponsev03.Document.Builder response = proto.nimbuspay.financialresponsev03.Document
                        .newBuilder();
             
                    ResultData7.Builder resBuilder = ResultData7.newBuilder();
                    resBuilder.setRsltDtls("Approved");

                    ProcessingResult10.Builder pBuilder = ProcessingResult10.newBuilder();
                    pBuilder.setRsltData(resBuilder);
                    
                    FinancialResponse2.Builder fBuilder = FinancialResponse2.newBuilder();
                    fBuilder.setPrcgRslt(pBuilder);

                    FinancialResponseV03.Builder fBuilderV03 = FinancialResponseV03.newBuilder();
                    fBuilderV03.setBody(fBuilder);

                    response.setFinRspn(fBuilderV03);
                        
                responseObserver.onNext(response.build());
            }

            @Override
            public void onError(Throwable t) {
                
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }

        };

    }

}
