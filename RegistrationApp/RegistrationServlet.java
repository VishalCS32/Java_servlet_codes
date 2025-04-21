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
                    body {
                        font-family: 'Segoe UI', Arial, sans-serif;
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        min-height: 100vh;
                        margin: 0;
                        background: linear-gradient(135deg, #2c3e50, #3498db);
                        color: #fff;
                    }
                    .form-container {
                        background: #ffffff;
                        padding: 30px;
                        border-radius: 10px;
                        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
                        width: 100%;
                        max-width: 400px;
                        text-align: left;
                    }
                    h1 {
                        text-align: center;
                        color: #2c3e50;
                        margin-bottom: 20px;
                    }
                    label {
                        display: block;
                        margin: 10px 0 5px;
                        color: #2c3e50;
                        font-weight: bold;
                    }
                    input[type="text"], input[type="email"], input[type="password"] {
                        width: 100%;
                        padding: 10px;
                        margin-bottom: 15px;
                        border: 1px solid #ccc;
                        border-radius: 5px;
                        box-sizing: border-box;
                        transition: border-color 0.3s ease;
                    }
                    input[type="text"]:focus, input[type="email"]:focus, input[type="password"]:focus {
                        border-color: #1abc9c;
                        outline: none;
                        box-shadow: 0 0 5px rgba(26, 188, 156, 0.5);
                    }
                    input[type="submit"] {
                        background-color: #1abc9c;
                        color: white;
                        padding: 12px;
                        border: none;
                        border-radius: 5px;
                        width: 100%;
                        cursor: pointer;
                        font-size: 1em;
                        transition: background-color 0.3s ease;
                    }
                    input[type="submit"]:hover {
                        background-color: #16a085;
                    }
                </style>
            </head>
            <body>
                <div class="form-container">
                    <h1>Register</h1>
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
                </div>
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

        // Basic validation
        if (firstName == null || lastName == null || email == null || password == null ||
            firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            response.getWriter().write("""
                <!DOCTYPE html>
                <html>
                <head>
                    <title>Error</title>
                    <style>
                        body {
                            font-family: 'Segoe UI', Arial, sans-serif;
                            display: flex;
                            justify-content: center;
                            align-items: center;
                            min-height: 100vh;
                            margin: 0;
                            background: linear-gradient(135deg, #2c3e50, #3498db);
                            color: #fff;
                        }
                        .error-container {
                            background: #ffffff;
                            padding: 30px;
                            border-radius: 10px;
                            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
                            text-align: center;
                            max-width: 400px;
                        }
                        h1 {
                            color: #e74c3c;
                            margin-bottom: 20px;
                        }
                        p {
                            color: #2c3e50;
                            font-size: 1.1em;
                        }
                        a {
                            color: #1abc9c;
                            text-decoration: none;
                            font-weight: bold;
                        }
                        a:hover {
                            color: #16a085;
                        }
                    </style>
                </head>
                <body>
                    <div class="error-container">
                        <h1>Error</h1>
                        <p>All fields are required. Please <a href="registration">try again</a>.</p>
                    </div>
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
                    body {
                        font-family: 'Segoe UI', Arial, sans-serif;
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        min-height: 100vh;
                        margin: 0;
                        background: linear-gradient(135deg, #2c3e50, #3498db);
                        color: #fff;
                    }
                    .confirmation-container {
                        background: #ffffff;
                        padding: 30px;
                        border-radius: 10px;
                        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
                        text-align: center;
                        max-width: 400px;
                    }
                    h1 {
                        color: #1abc9c;
                        margin-bottom: 20px;
                    }
                    p {
                        color: #2c3e50;
                        font-size: 1.1em;
                        margin: 10px 0;
                    }
                    a {
                        color: #1abc9c;
                        text-decoration: none;
                        font-weight: bold;
                    }
                    a:hover {
                        color: #16a085;
                    }
                </style>
            </head>
            <body>
                <div class="confirmation-container">
                    <h1>Registration Successful</h1>
                    <p><strong>First Name:</strong> %s</p>
                    <p><strong>Last Name:</strong> %s</p>
                    <p><strong>Email:</strong> %s</p>
                    <p><strong>Password:</strong> %s</p>
                    <p><a href="registration">Register another user</a></p>
                </div>
            </body>
            </html>
            """.formatted(firstName, lastName, email, password));
    }
}