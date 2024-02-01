package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class HomeFragment extends Fragment {

    private Map<String, String> topicContentMap;
    private Map<String, String> topicToButtonIdMap;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        initializeButtonInfoMap();
        initializeTopicToButtonIdMap();

        ListView listViewLearning = view.findViewById(R.id.listViewLearning);
        String[] javaTopics = {
                "Java Intro", "Java Syntax", "Java Output", "Java Comments", "Java Variables",
                "Java Data Types", "Java Type Casting", "Java Operators", "Java Strings", "Java Math",
                "Java Booleans", "Java If...Else", "Java Switch", "Java While Loop", "Java For Loop",
                "Java Break/Continue", "Java Arrays", "Java Methods", "Java Method Parameters",
                "Java Method Overloading", "Java Scope", "Java Recursion", "Java Classes", "Java OOP",
                "Java Classes/Objects", "Java Class Attributes", "Java Class Methods", "Java Constructors",
                "Java Modifiers", "Java Encapsulation", "Java Packages / API", "Java Inheritance",
                "Java Polymorphism", "Java Inner Classes", "Java Abstraction", "Java Interface", "Java Enums",
                "Java User Input", "Java Date", "Java ArrayList", "Java LinkedList", "Java HashMap",
                "Java HashSet", "Java Iterator", "Java Wrapper Classes", "Java Exceptions", "Java RegEx",
                "Java Threads", "Java Lambda", "Java File Handling", "Java Files", "Java Create/Write Files",
                "Java Read Files", "Java Delete Files", "Add Two Numbers", "Count Words",
                "Reverse a String", "Sum of Array Elements", "Area of Rectangle", "Even or Odd Number",
                "Java Reference", "Java Keywords", "Java String Methods", "Java Math Methods",
                "Java Examples", "Java Compiler", "Java Exercises", "Java Quiz", "Java Server", "Java Certificate"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, javaTopics);
        listViewLearning.setAdapter(adapter);

        listViewLearning.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String topic = javaTopics[position];
                String buttonId = topicToButtonIdMap.get(topic); // Get the button ID
                String content = topicContentMap.getOrDefault(buttonId, "No content available.");

                new AlertDialog.Builder(getActivity())
                        .setTitle(topic)
                        .setMessage(content)
                        .setPositiveButton(android.R.string.ok, null)
                        .show();
            }
        });

        return view;
    }

    private void initializeButtonInfoMap() {
        topicContentMap = new HashMap<>();
        try {
            InputStream is = getActivity().getAssets().open("reading.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, StandardCharsets.UTF_8);

            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String buttonId = obj.getString("buttonId");
                String description = obj.getString("description");
                topicContentMap.put(buttonId, description);

                // Log the buttonId and description for debugging
                Log.d("HomeFragment", "Loaded " + buttonId + ": " + description);
            }

            // Log the size of the map for debugging
            Log.d("HomeFragment", "Total items in topicContentMap: " + topicContentMap.size());
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("HomeFragment", "Error reading JSON: " + e.getMessage());
        }
    }


    private void initializeTopicToButtonIdMap() {
        topicToButtonIdMap = new HashMap<>();
        topicToButtonIdMap.put("Java Intro", "btnJavaIntro");
        topicToButtonIdMap.put("Java Syntax", "btnJavaSyntax");
        topicToButtonIdMap.put("Java Output", "btnJavaOutput");
        topicToButtonIdMap.put("Java Comments", "btnJavaComments");
        topicToButtonIdMap.put("Java Variables", "btnJavaVariables");
        topicToButtonIdMap.put("Java Data Types", "btnJavaDataTypes");
        topicToButtonIdMap.put("Java Type Casting", "btnJavaTypeCasting");
        topicToButtonIdMap.put("Java Operators", "btnJavaOperators");
        topicToButtonIdMap.put("Java Strings", "btnJavaStrings");
        topicToButtonIdMap.put("Java Math", "btnJavaMath");
        topicToButtonIdMap.put("Java Booleans", "btnJavaBooleans");
        topicToButtonIdMap.put("Java If...Else", "btnJavaIfElse");
        topicToButtonIdMap.put("Java Switch", "btnJavaSwitch");
        topicToButtonIdMap.put("Java While Loop", "btnJavaWhileLoop");
        topicToButtonIdMap.put("Java For Loop", "btnJavaForLoop");
        topicToButtonIdMap.put("Java Break/Continue", "btnJavaBreakContinue");
        topicToButtonIdMap.put("Java Arrays", "btnJavaArrays");
        topicToButtonIdMap.put("Java Methods", "btnJavaMethods");
        topicToButtonIdMap.put("Java Method Parameters", "btnJavaMethodParameters");
        topicToButtonIdMap.put("Java Method Overloading", "btnJavaMethodOverloading");
        topicToButtonIdMap.put("Java Scope", "btnJavaScope");
        topicToButtonIdMap.put("Java Recursion", "btnJavaRecursion");
        topicToButtonIdMap.put("Java Classes", "btnJavaClasses");
        topicToButtonIdMap.put("Java OOP", "btnJavaOOP");
        topicToButtonIdMap.put("Java Classes/Objects", "btnJavaClassesObjects");
        topicToButtonIdMap.put("Java Class Attributes", "btnJavaClassAttributes");
        topicToButtonIdMap.put("Java Class Methods", "btnJavaClassMethods");
        topicToButtonIdMap.put("Java Constructors", "btnJavaConstructors");
        topicToButtonIdMap.put("Java Modifiers", "btnJavaModifiers");
        topicToButtonIdMap.put("Java Encapsulation", "btnJavaEncapsulation");
        topicToButtonIdMap.put("Java Packages / API", "btnJavaPackagesAPI");
        topicToButtonIdMap.put("Java Inheritance", "btnJavaInheritance");
        topicToButtonIdMap.put("Java Polymorphism", "btnJavaPolymorphism");
        topicToButtonIdMap.put("Java Inner Classes", "btnJavaInnerClasses");
        topicToButtonIdMap.put("Java Abstraction", "btnJavaAbstraction");
        topicToButtonIdMap.put("Java Interface", "btnJavaInterface");
        topicToButtonIdMap.put("Java Enums", "btnJavaEnums");
        topicToButtonIdMap.put("Java User Input", "btnJavaUserInput");
        topicToButtonIdMap.put("Java Date", "btnJavaDate");
        topicToButtonIdMap.put("Java ArrayList", "btnJavaArrayList");
        topicToButtonIdMap.put("Java LinkedList", "btnJavaLinkedList");
        topicToButtonIdMap.put("Java HashMap", "btnJavaHashMap");
        topicToButtonIdMap.put("Java HashSet", "btnJavaHashSet");
        topicToButtonIdMap.put("Java Iterator", "btnJavaIterator");
        topicToButtonIdMap.put("Java Wrapper Classes", "btnJavaWrapperClasses");
        topicToButtonIdMap.put("Java Exceptions", "btnJavaExceptions");
        topicToButtonIdMap.put("Java RegEx", "btnJavaRegEx");
        topicToButtonIdMap.put("Java Threads", "btnJavaThreads");
        topicToButtonIdMap.put("Java Lambda", "btnJavaLambda");
        topicToButtonIdMap.put("Java File Handling", "btnJavaFileHandling");
        topicToButtonIdMap.put("Java Files", "btnJavaFiles");
        topicToButtonIdMap.put("Java Create/Write Files", "btnJavaCreateWriteFiles");
        topicToButtonIdMap.put("Java Read Files", "btnJavaReadFiles");
        topicToButtonIdMap.put("Java Delete Files", "btnJavaDeleteFiles");
        topicToButtonIdMap.put("Java How To", "btnJavaHowTo");
        topicToButtonIdMap.put("Add Two Numbers", "btnAddTwoNumbers");
        topicToButtonIdMap.put("Count Words", "btnCountWords");
        topicToButtonIdMap.put("Reverse a String", "btnReverseString");
        topicToButtonIdMap.put("Sum of Array Elements", "btnSumArrayElements");
        topicToButtonIdMap.put("Area of Rectangle", "btnAreaRectangle");
        topicToButtonIdMap.put("Even or Odd Number", "btnEvenOddNumber");
        topicToButtonIdMap.put("Java Reference", "btnJavaReference");
        topicToButtonIdMap.put("Java Keywords", "btnJavaKeywords");
        topicToButtonIdMap.put("Java String Methods", "btnJavaStringMethods");
        topicToButtonIdMap.put("Java Math Methods", "btnJavaMathMethods");
        topicToButtonIdMap.put("Java Examples", "btnJavaExamples");
        topicToButtonIdMap.put("Java Compiler", "btnJavaCompiler");
        topicToButtonIdMap.put("Java Exercises", "btnJavaExercises");
        topicToButtonIdMap.put("Java Quiz", "btnJavaQuiz");
        topicToButtonIdMap.put("Java Server", "btnJavaServer");
        topicToButtonIdMap.put("Java Certificate", "btnJavaCertificate");
    }
}
