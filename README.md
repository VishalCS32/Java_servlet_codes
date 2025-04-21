README.md Content for GitHub
markdown
# DateTimeApp: Real-Time Clock Servlet for Apache Tomcat 10 (Windows)

This repository contains a Java servlet application (`DateTimeApp`) that displays a real-time digital clock, updating every second. The servlet is built for Apache Tomcat 10 on Windows, using Jakarta EE 9 (`jakarta.servlet`). The UI features a modern design with a gradient background, a dark card container, neon cyan text, and a hover effect.

## Project Overview
- **Purpose**: Display a real-time clock in a browser (e.g., `04/21/2025, 02:30:45 PM`).
- **Technology**: Java Servlet, Tomcat 10, OpenJDK 17.
- **Features**:
  - Real-time clock updated via JavaScript.
  - Styled UI with a gradient background, card layout, and neon cyan accents.
- **Environment**: Windows 10/11.

## Prerequisites
- Windows 10 or 11
- Internet access to download Tomcat and OpenJDK
- Basic familiarity with Command Prompt
- Text editor (e.g., Notepad, VS Code)

## Project Structure
DateTimeApp/
├── DateTimeServlet.java  # Servlet code
├── WEB-INF/
│   ├── classes/          # Compiled .class files
│   └── web.xml           # Servlet configuration

## Setup Instructions

### Step 1: Install OpenJDK 17
Tomcat 10 requires Java 11 or later. We use OpenJDK 17 (LTS).

1. **Download OpenJDK 17**:
   - Visit [Adoptium](https://adoptium.net/) or [Oracle](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html).
   - Download the Windows x64 MSI (e.g., `OpenJDK17U-jdk_x64_windows_hotspot_17.0.XX.msi`).

2. **Install OpenJDK**:
   - Run the MSI installer, accepting defaults (installs to `C:\Program Files\Eclipse Adoptium\jdk-17.0.XX-hotspot`).

3. **Set Environment Variables**:
   - Open **Control Panel** → **System and Security** → **System** → **Advanced system settings** → **Environment Variables**.
   - Add under **System Variables**:
     - **New**: Name: `JAVA_HOME`, Value: `C:\Program Files\Eclipse Adoptium\jdk-17.0.XX-hotspot` (adjust path).
     - Edit **Path**, add: `%JAVA_HOME%\bin`.

4. **Verify Java**:
   ```cmd
   java -version
   javac -version
   Should show OpenJDK 17 (e.g., openjdk 17.0.XX).
Step 2: Install Apache Tomcat 10
Download Tomcat 10:
Go to Apache Tomcat 10.
Download the Windows 64-bit ZIP (e.g., apache-tomcat-10.1.XX.zip).
Extract Tomcat:
Extract to C:\Program Files\Apache Software Foundation\Tomcat 10.0.
Path: C:\Program Files\Apache Software Foundation\Tomcat 10.0\bin, lib, webapps.
Start Tomcat:
cmd
cd "C:\Program Files\Apache Software Foundation\Tomcat 10.0\bin"
startup.bat
Verify Tomcat:
Open http://localhost:8080 in a browser.
See the Tomcat welcome page.
Stop Tomcat with shutdown.bat.
Step 3: Set Up the DateTimeApp Project
Clone or Download Repository:
Clone this repository:
bash
git clone https://github.com/your-username/DateTimeApp.git
cd DateTimeApp
Or download and extract the ZIP to C:\Users\YourUsername\DateTimeApp.
Verify Files:
Ensure DateTimeServlet.java and WEB-INF\web.xml are present.
If not, create them:DateTimeServlet.java:
java
import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import java.io.IOException;

public class DateTimeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().write("""
            <!DOCTYPE html>
            <html>
            <head>
                <title>Real-Time Digital Clock</title>
                <style>
                    body {
                        font-family: 'Segoe UI', Arial, sans-serif;
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        min-height: 100vh;
                        margin: 0;
                        background: linear-gradient(135deg, #1e3c72, #2a5298);
                        color: #fff;
                    }
                    .clock-container {
                        background: #1c2526;
                        padding: 30px;
                        border-radius: 15px;
                        box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3);
                        text-align: center;
                        transition: transform 0.3s ease;
                    }
                    .clock-container:hover {
                        transform: scale(1.05);
                    }
                    h1 {
                        font-size: 2em;
                        margin-bottom: 20px;
                        color: #00ffcc;
                        text-shadow: 0 0 10px #00ffcc;
                    }
                    #clock {
                        font-size: 3.5em;
                        font-weight: bold;
                        color: #00ffcc;
                        background: #2e3b4e;
                        padding: 15px 25px;
                        border-radius: 10px;
                        display: inline-block;
                        text-shadow: 0 0 8px #00ffcc;
                        letter-spacing: 2px;
                    }
                </style>
            </head>
            <body>
                <div class="clock-container">
                    <h1>Real-Time Digital Clock</h1>
                    <div id="clock"></div>
                </div>
                <script>
                    function updateClock() {
                        const now = new Date();
                        const formattedTime = now.toLocaleString('en-US', {
                            year: 'numeric',
                            month: '2-digit',
                            day: '2-digit',
                            hour: '2-digit',
                            minute: '2-digit',
                            second: '2-digit',
                            hour12: true
                        });
                        document.getElementById('clock').textContent = formattedTime;
                    }
                    updateClock();
                    setInterval(updateClock, 1000);
                </script>
            </body>
            </html>
            """);
    }
}
WEB-INF/web.xml:
xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="https://jakarta.ee/xml/ns/jakartaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee https://jakarta.ee/xml/ns/jakartaee/web-app_5_0.xsd"
         version="5.0">
    <servlet>
        <servlet-name>DateTimeServlet</servlet-name>
        <servlet-class>DateTimeServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>DateTimeServlet</servlet-name>
        <url-pattern>/datetime</url-pattern>
    </servlet-mapping>
</web-app>
Create classes Directory (if missing):
cmd
mkdir WEB-INF\classes
Step 4: Compile the Servlet
Compile:
cmd
cd C:\Users\YourUsername\DateTimeApp
javac -cp "C:\Program Files\Apache Software Foundation\Tomcat 10.0\lib\servlet-api.jar" -d WEB-INF\classes DateTimeServlet.java
Verify:
cmd
dir WEB-INF\classes
Should show DateTimeServlet.class.
Step 5: Deploy to Tomcat
Copy to Tomcat:
cmd
xcopy /E /I C:\Users\YourUsername\DateTimeApp "C:\Program Files\Apache Software Foundation\Tomcat 10.0\webapps\DateTimeApp"
Restart Tomcat:
cmd
cd "C:\Program Files\Apache Software Foundation\Tomcat 10.0\bin"
shutdown.bat
startup.bat
Step 6: Test the Application
Open the Clock:
Go to http://localhost:8080/DateTimeApp/datetime in a browser.
See a dark card with a neon cyan “Real-Time Digital Clock” heading and the current date/time (e.g., 04/21/2025, 02:30:45 PM) updating every second.
Verify UI:
Gradient background (dark to light blue).
Hover effect: Card scales slightly.
Large, bold clock text with neon cyan glow.
Troubleshooting
“javac is not recognized”:
Ensure JDK is in PATH:
cmd
setx PATH "%PATH%;C:\Program Files\Eclipse Adoptium\jdk-17.0.XX-hotspot\bin"
Reopen Command Prompt.
“package jakarta.servlet does not exist”:
Verify servlet-api.jar:
cmd
dir "C:\Program Files\Apache Software Foundation\Tomcat 10.0\lib\servlet-api.jar"
Adjust path if Tomcat is elsewhere.
404 Error:
Confirm URL: http://localhost:8080/DateTimeApp/datetime.
Check webapps:
cmd
dir "C:\Program Files\Apache Software Foundation\Tomcat 10.0\webapps\DateTimeApp"
Tomcat Not Running:
Ensure startup.bat ran without errors.
Check logs:
cmd
type "C:\Program Files\Apache Software Foundation\Tomcat 10.0\logs\catalina.out"
Optional: Run Tomcat as a Service
Install as a service:
cmd
cd "C:\Program Files\Apache Software Foundation\Tomcat 10.0\bin"
service.bat install
Start/stop:
cmd
net start Tomcat10
net stop Tomcat10
Contributing
Feel free to fork this repository, submit issues, or create pull requests to enhance the servlet (e.g., add timezone support, custom formats).
License
This project is licensed under the MIT License.

---

### Instructions to Use the README in GitHub

1. **Create a GitHub Repository**:
   - Go to [GitHub](https://github.com/), sign in, and click **New repository**.
   - Name it (e.g., `DateTimeApp`), set it to **Public** or **Private**, and initialize with a README (optional, you’ll overwrite it).
   - Click **Create repository**.

2. **Set Up the Project Locally**:
   - Create the `DateTimeApp` project directory:
     ```cmd
     mkdir C:\Users\YourUsername\DateTimeApp
     cd C:\Users\YourUsername\DateTimeApp
     mkdir WEB-INF\classes
     ```
   - Save `DateTimeServlet.java` and `WEB-INF\web.xml` (content provided in the README) using a text editor.

3. **Save the README**:
   - Copy the Markdown content above.
   - Save as `README.md` in `C:\Users\YourUsername\DateTimeApp` using Notepad or VS Code.

4. **Initialize Git and Push to GitHub**:
   - Install [Git for Windows](https://git-scm.com/download/win) if not already installed.
   - In Command Prompt:
     ```cmd
     cd C:\Users\YourUsername\DateTimeApp
     git init
     git add .
     git commit -m "Initial commit with DateTimeApp servlet"
     git remote add origin https://github.com/your-username/DateTimeApp.git
     git push -u origin main
     ```
   - Replace `your-username` with your GitHub username.
   - Authenticate with your GitHub credentials or a personal access token.

5. **Verify on GitHub**:
   - Visit your repository (e.g., `https://github.com/your-username/DateTimeApp`).
   - The `README.md` should render as the repository’s main page, with formatted headings, code blocks, and links.

---

### Notes
- **Content**: The README uses `DateTimeApp` with the modern UI (gradient background, neon cyan clock, card container) as the example, as requested.
- **GitHub-Friendly**: Includes sections typical for GitHub READMEs (overview, setup, troubleshooting, contributing).
- **Assumptions**: The repository contains `DateTimeServlet.java` and `web.xml`. If you want to include additional files (e.g., a WAR file), let me know.
- **Tomcat Path**: Adjust `C:\Program Files\Apache Software Foundation\Tomcat 10.0` if your Tomcat is elsewhere (e.g., `C:\apache-tomcat-10.1.XX`).

### If You Need Help
- Share any errors during Git setup or push (e.g., authentication issues).
- Specify if you want additions to the README (e.g., badges, screenshots, deployment to other platforms).
- Provide your Tomcat path if it differs:
  ```cmd
  dir /s "C:\*servlet-api.jar"
Once you’ve pushed the README to GitHub, let me know how it looks or if you need further tweaks (e.g., adding a license file, CI/CD setup)!