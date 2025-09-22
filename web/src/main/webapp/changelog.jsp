<%@ page import="java.io.*" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Document</title>
</head>
<body>
  <pre><%
    try (
      InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("CHANGELOG.md");
      InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
      BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    ) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
          out.println(line); // Print each line to the JSP output
      }
    } catch (IOException e) {
      out.println("Error reading file: " + e.getMessage());
    }
  %></pre>
</body>
</html>