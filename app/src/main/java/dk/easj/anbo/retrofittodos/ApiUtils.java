package dk.easj.anbo.retrofittodos;

class ApiUtils {
    private ApiUtils() {
    }

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    public static TodoService getTodoService() {

        return RetrofitClient.getClient(BASE_URL).create(TodoService.class);
    }
}
