package pojo;

public class PojoClass {
	
	String createdBy;
	String projectName;
	String status;
	int teamSize;
	
	//step 2 create a constructor to initilize the value
	
	public PojoClass(String createdBy,String projectName,String status,int teamSize )
	{
		this.createdBy= createdBy;
		this.projectName=projectName;
		this.status=status;
		this.teamSize=teamSize;
	}

	
	public String getCreatedBy() {
		return createdBy;
	}

	

	public String getProjectName() {
		return projectName;
	}


	public String getStatus() {
		return status;
	}

	
	public int getTeamSize() {
		return teamSize;
	}

	
	
}
