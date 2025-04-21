# Java Servlet for Apache Tomcat 10 on Windows

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This repository contains a Java servlet application, `DateTimeApp`, that displays a real-time digital clock updating every second. Built for Apache Tomcat 10 using Jakarta EE 9 (`jakarta.servlet`). This guide explains how to set it up on Windows.

## Project Overview

- **Purpose**: Display a real-time clock in a browser (e.g., `04/21/2025, 02:30:45 PM`).
- **Technology**: Java Servlet, Apache Tomcat 10, OpenJDK 17.
- **Environment**: Windows 10/11.

## Prerequisites

- Windows 10 or 11
- Internet access to download Tomcat and OpenJDK
- Basic familiarity with Command Prompt
- Text editor (e.g., Notepad, [VS Code](https://code.visualstudio.com/))
- [Git](https://git-scm.com/download/win) (optional, for cloning)

## Project Structure

DateTimeApp/

├── DateTimeServlet.java  # Servlet code

├── WEB-INF/

│   ├── classes/          # Compiled .class files (created during compilation)

│   └── web.xml           # Servlet configuration



## Setup Instructions

### 1. Install OpenJDK 17

Tomcat 10 requires Java 11 or later. We use OpenJDK 17 (Long-Term Support).

1. **Download OpenJDK 17**:
   - Visit [Adoptium](https://adoptium.net/) or [Oracle](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html).
   - Download the Windows x64 MSI (e.g., `OpenJDK17U-jdk_x64_windows_hotspot_17.0.XX.msi`).

2. **Install OpenJDK**:
   - Run the MSI installer, accepting defaults (installs to `C:\Program Files\Eclipse Adoptium\jdk-17.0.XX-hotspot`).

3. **Set Environment Variables**:
   - Open **Control Panel** → **System and Security** → **System** → **Advanced system settings** → **Environment Variables**.
   - Under **System Variables**:
     - **New**: Name: `JAVA_HOME`, Value: `C:\Program Files\Eclipse Adoptium\jdk-17.0.XX-hotspot` (adjust to your JDK path).
     - Edit **Path**, add: `%JAVA_HOME%\bin`.

4. **Verify Java**:
   ```cmd
   java -version
   javac -version


   Should show OpenJDK 17 (e.g., openjdk 17.0.XX).
2. Install Apache Tomcat 10
   - Download Tomcat 10:
     - Go to Apache Tomcat 10.
     - Download the Windows 64-bit ZIP (e.g., apache-tomcat-10.1.XX.zip).

   - Extract Tomcat:
     - Extract to C:\Program Files\Apache Software Foundation\Tomcat 10.0 (create folder if needed).
     - Path includes: C:\Program Files\Apache Software Foundation\Tomcat 10.0\bin, lib, webapps.
   - Start Tomcat: 
     ```cmd
     cd "C:\Program Files\Apache Software Foundation\Tomcat 10.0\bin"
      startup.bat

   - Verify Tomcat:
     - Open http://localhost:8080 in a browser to see the Tomcat welcome page.
     - Stop Tomcat:


    ```cmd
       shutdown.bat


3. Set Up the DateTimeApp Project
   - Clone or Download Repository:
      - Clone:

         ```bash
         git clone https://github.com/your-username/DateTimeApp.git
          cd DateTimeApp

    - Or download the ZIP from GitHub and extract to C:\Users\YourUsername\DateTimeApp.

   - Verify Files:
      - Ensure DateTimeServlet.java and WEB-INF\web.xml are present.

      - If missing, create them: DateTimeServlet.java:

  
```java
          
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
```
WEB-INF/web.xml:

```xml

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

```
- Create classes Directory (if missing):

```cmd

mkdir WEB-INF\classes

```

4. Compile the Servlet

- Compile:

  ```cmd
  cd C:\Users\YourUsername\DateTimeApp
  javac -cp "C:\Program Files\Apache Software Foundation\Tomcat 10.0\lib\servlet-api.jar" -d WEB-INF\classes DateTimeServlet.java

- Verify:

  ```cmd
  dir WEB-INF\classes

Should show DateTimeServlet.class.

5. Deploy to Tomcat

  - Copy to Tomcat:

```cmd
xcopy /E /I C:\Users\YourUsername\DateTimeApp "C:\Program Files\Apache Software Foundation\Tomcat 10.0\webapps\DateTimeApp"
```
  - Restart Tomcat:

    ```cmd

    cd "C:\Program Files\Apache Software Foundation\Tomcat 10.0\bin"
    shutdown.bat
    startup.bat

6. Test the Application

   - Open the Clock:
   - Visit http://localhost:8080/DateTimeApp/datetime in a browser.





 
