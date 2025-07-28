class Project{

	private String projectCode;
	private String name ;
	private String client;
	private String buLeadName;
	
	public Project(String projectCode, String name, String client, String buLeadName) {
        this.projectCode = projectCode;
        this.name = name;
        this.client = client;
        this.buLeadName = buLeadName;
    }
    
    public String getName() { return name; }
    public String getClient() { return client; }
    public String getBuLeadName() { return buLeadName; }
      
}
