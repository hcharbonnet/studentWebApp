package studentWebApp;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;
 
import org.springframework.web.client.RestTemplate;
import springmvc.studentWebApp.Model.Student;

public class SpringRestTest {
	public static final String REST_SERVICE_URI = "http://localhost:8080/studentWebApp";
	
	//---Get one student---//
    private static void testGetStudent(){
        System.out.println("-------Testing getStudent-------");
        RestTemplate restTemplate = new RestTemplate();
        Student student = restTemplate.getForObject(REST_SERVICE_URI+"/student/1", Student.class);
        System.out.println(student);
    }
	
    //---Get all students---//
    @SuppressWarnings("unchecked")
    private static void testGetAllStudents(){
        System.out.println("-------Testing getAllStudents-------");
        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> studentsMap = restTemplate.getForObject(REST_SERVICE_URI+"/student/", List.class);
         
        if(studentsMap!=null){
            for(LinkedHashMap<String, Object> map : studentsMap){
                System.out.println("Student : id="+map.get("id")+", FullName="+map.get("fullName"));
            }
        }else{
            System.out.println("No students in the class.");
        }
    }
    
	//---Create one student---//
    private static void testAddStudent(){
        System.out.println("-------Testing addStudent-------");
        RestTemplate restTemplate = new RestTemplate();
        Student student = new Student("ex", "added", 8);
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/student/", student, Student.class);
        System.out.println("Location: " + uri.toASCIIString());
    }
    
	//---Edit one student---//
    private static void testEditStudent(){
        System.out.println("-------Testing editStudent-------");
        RestTemplate restTemplate = new RestTemplate();
        Student student = new Student("ex", "edited", 9);
        restTemplate.put(REST_SERVICE_URI+"/student/9", student);
        System.out.println(student);
    }
    
	//---Delete one student---//
    private static void testDeleteStudent(){
        System.out.println("-------Testing deleteStudent-------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/student/3");
    }
    
	//---Delete all students---//
    private static void testDeleteAllStudents(){
        System.out.println("-------Testing deleteStudent-------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/student/");
    }
    
    public static void main(String args[]){
    	//testGetAllStudents();
        testGetStudent();
        /*testAddStudent();
    	testGetAllStudents();
        testEditStudent();
    	testGetAllStudents();
        testDeleteStudent();
    	testGetAllStudents();
        testDeleteAllStudents();
    	testGetAllStudents();
    	*/
    }
}
