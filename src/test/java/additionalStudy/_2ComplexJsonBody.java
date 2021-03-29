package additionalStudy;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _2ComplexJsonBody {
     /*
1. Print No of courses returned by API
2. Print Purchase Amount
3. Print Title of the first course
4. Print All course titles and their respective Prices
5. Print no of copies sold by RPA Course
6. Verify if Sum of all Course prices matches with Purchase Amount
         */

    @Test
    public void method1() {
        JsonPath jsonPath=new JsonPath(Payload.addCourse());
        // print number of courses
        int noCourses=jsonPath.getInt("courses.size()");
        System.out.println(noCourses);

        // print purchase amount
        int purchaseAmount=jsonPath.getInt("dashboard.purchaseAmount");
        System.out.println(purchaseAmount);

        // print first course title
        String firstTitle=jsonPath.getString("courses[0].title");
        System.out.println(firstTitle);
        // print second course title
        String secondTitle=jsonPath.getString("courses[1].title");
        System.out.println(secondTitle);
        // print last course title
        String lastTitle=jsonPath.getString("courses[-1].title");
        System.out.println(lastTitle);

        // print all the titles and respective prices

        for (int i = 0; i < noCourses; i++) {
            System.out.println(jsonPath.getString("courses["+i+"].title")+":"+jsonPath.getInt("courses["+i+"].price"));
        }

        // number of copies sold by RPA course
        for (int i = 0; i < noCourses; i++) {
            int copies=jsonPath.getInt("courses["+i+"].copies");
            if(jsonPath.getString("courses["+i+"].title").equals("RPA")){
                System.out.println(copies);
                break;
            }
        }

        // Verify the sum of all course prices match with purchaseAmount
        int coursePrice=0;
        for (int i = 0; i <noCourses ; i++) {
             coursePrice+=(jsonPath.getInt("courses["+i+"].price"))*(jsonPath.getInt("courses["+i+"].copies"));

        }
        Assert.assertEquals(coursePrice,jsonPath.getInt("dashboard.purchaseAmount"));

    }
}