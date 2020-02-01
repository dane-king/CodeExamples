package lambdas;

public class InternalService {
    private ExternalService externalService;

    public InternalService(ExternalService externalService) {
        this.externalService = externalService;
    }


    public String getStuff(){
        return externalService.getStuff();
    }

    public Integer getNumbers(){
        return 5;
    }
}
