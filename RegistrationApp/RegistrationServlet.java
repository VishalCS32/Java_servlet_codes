import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {
    // Handle GET request: Display the registration form
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().write("""
            <!DOCTYPE html>
            <html>
            <head>
                <title>Client Registration</title>
                <style>
                    body { font-family: Arial, sans-serif; margin: 40px; }
                    form { max-width: 400px; margin: auto; padding: 20px; border: 1px solid #ccc; border-radius: 5px; }
                    label { display: block; margin: 10px 0 5px; }
                    input[type="text"], input[type="email"], input[type="password"] {
                        width: 93%; padding: 8px; margin-bottom: 10px; border: 1px solid #ccc; border-radius: 4px;
                    }
                    input[type="submit"] { background-color: #007BFF; color: white; padding: 10px 15px; border: none; border-radius: 4px; cursor: pointer; }
                    input[type="submit"]:hover { background-color: #0056b3; }
                </style>
            </head>
            <body>
                <form action="registration" method="post">
                    <label for="firstName">First Name:</label>
                    <input type="text" id="firstName" name="firstName">
                    <label for="lastName">Last Name:</label>
                    <input type="text" id="lastName" name="lastName">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password">
                    <input type="submit" value="Register">
                </form>
            </body>
            </html>
            """);
    }

    // Handle POST request: Process form data
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Basic validation to ensure fields are not empty
        if (firstName == null || lastName == null || email == null || password == null ||
            firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            response.getWriter().write("""
                <!DOCTYPE html>
                <html>
                <head><title>Error</title></head>
                <body>
                    <h1>Error</h1>
                    <p>All fields are required. Please <a href="registration">try again</a>.</p>
                </body>
                </html>
                """);
            return;
        }

        // Display submitted information
        response.getWriter().write("""
            <!DOCTYPE html>
            <html>
            <head>
                <title>Registration Confirmation</title>
                <style>
                    body { font-family: Arial, sans-serif; margin: 40px; text-align: center; }
                    h1 { color: #007BFF; }
                    p { font-size: 1.1em; }
                </style>
            </head>
            <body>
                <h1>Registration Successful</h1>
                <p><strong>First Name:</strong> %s</p>
                <p><strong>Last Name:</strong> %s</p>
                <p><strong>Email:</strong> %s</p>
                <p><strong>Password:</strong> %s</p>
                <p><a href="registration">Register another user</a></p>
            </body>
            </html>
            """.formatted(firstName, lastName, email, password));
    }
}
