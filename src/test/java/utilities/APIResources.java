package utilities;

public enum APIResources {

    ADDpodcast("/podcasts/submit"),
    GETpodcast("/podcasts/");

    private String resource;

    APIResources(String resource)
    {
        this.resource=resource;
    }

    public String getResource()
    {
        return resource;
    }
}
