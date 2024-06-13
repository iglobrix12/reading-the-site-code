package test;

import org.mozilla.javascript.*;
import test.JS.HttpJS;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class RhinoFileExample {
    public static void main(String[] ma) {
        Context ctx = Context.enter();
        try {
            Scriptable scope = ctx.initStandardObjects();

            HttpJS guiAPI = new HttpJS();

            ScriptableObject.putProperty(scope, "connect", Context.javaToJS(guiAPI, scope));

            try (Reader reader = new FileReader("example.kts")) {
                ctx.evaluateReader(scope, reader, "example.kts", 1, null);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}