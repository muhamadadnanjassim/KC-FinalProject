package com.example.steponstep;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class Store extends AppCompatActivity {

    ArrayList<StoreItem> stores = new ArrayList<>();
    ListView listView;
    CardView hrs;
    ImageView home,donate;
    float v=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.store);

        hrs = findViewById(R.id.hrs);
        home = findViewById(R.id.homei);
        donate = findViewById(R.id.donatei);
        listView = findViewById(R.id.listview);

        //objects
        StoreItem s1 = new StoreItem("IPhone","Apple",R.drawable.iphones);
        StoreItem s2 = new StoreItem("IPad","Xcite",R.drawable.ipad);
        StoreItem s3 = new StoreItem("Samsung","Xcite",R.drawable.samsung);
        StoreItem s4 = new StoreItem("Nike","Blink",R.drawable.nike2);
        StoreItem s5 = new StoreItem("Ray Ban","Ray Ban",R.drawable.glasses);
        StoreItem s6 = new StoreItem("MacBook","Apple",R.drawable.macbook);
        StoreItem s7 = new StoreItem("Apple Watch","Blink",R.drawable.watch);
        StoreItem s8 = new StoreItem("Rolex","Rolex",R.drawable.watch2);

        stores.add(s1);
        stores.add(s2);
        stores.add(s3);
        stores.add(s4);
        stores.add(s5);
        stores.add(s6);
        stores.add(s7);
        stores.add(s8);

        StoreAdapter i = new StoreAdapter(this,0,stores);

        listView.setAdapter(i);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
/*
                Intent details = new Intent(MainActivity.this, MainActivity2.class);
                details.putExtra("item", details);
                startActivity(details);
*/
                if(i==0) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://r.search.yahoo.com/cbclk2/dWU9NDdEMDVDMjlFQ0RFNDEyQSZ1dD0xNjYyNTc5OTExNTU2JnVvPTc3NzkwNjQ2NjMyMTk5Jmx0PTImcz0xJmVzPS42MVU0a2NHUFNfZWJLNWZySDFqQ1dGRWRYYzR3Z3dwWnNOdW5sc2FFZWtTb3o0cW1BLS0-/RV=2/RE=1662608711/RO=10/RU=https%3a%2f%2fwww.bing.com%2faclick%3fld%3de8jZxhni5l4YPdsk8BmPo5kTVUCUxMq6uLw55BNI0OKK_JFXnTz2knFWT4VLXVqKE1LeNlpKRd5LGNl0hhDMfZ6TUXOMxmvQTnXUsYM_PJMwZPmqgCqZ_xpXUDA4-iofeKhfv-NJMrVfUspG_c1FlRP23PD9NYjVmQq0nqhJbYYzRFFXTZrI_bHBFBNQkngUpmhEs6Vw%26u%3daHR0cHMlM2ElMmYlMmZ3d3cuYXBwbGUuY29tJTJmYXBwbGUtZXZlbnRzJTNmY2lkJTNkd3dhLXVzLWt3YmktZmVhdHVyZXMtc2xpZC0tQnJhbmQtYXBwbGVsaXZlLXBvc3QtJTI2bXRpZCUzZDIwOTI1ZTF0MzkxNjklMjZhb3NpZCUzZHAyMzglMjZtbmlkJTNkMnplM2RPZWwtZGNfbXRpZF8yMDkyNWUxdDM5MTY5X3BjcmlkXzc3NzkwNjQ2NjMyMTk5X3BncmlkXzEyNDQ2NDc3NTEwODg4MzRf%26rlid%3d12643b306de91ad2806b5828992edd13/RK=2/RS=K5gfT2W1rRHYenaeFENrZI8I5eI-;_ylt=AwrEmMfH9BhjW8cANNdXNyoA;_ylu=Y29sbwNiZjEEcG9zAzEEdnRpZAMEc2VjA292LXRvcA--;_ylc=X3IDMgRydAMw?IG=0ac498c7690a4921940000000059c551")));

                }else if(i==1){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://r.search.yahoo.com/_ylt=AwrFPyVY9Rhj1jIA0tVXNyoA;_ylu=Y29sbwNiZjEEcG9zAzEEdnRpZAMEc2VjA3Ny/RV=2/RE=1662608857/RO=10/RU=https%3a%2f%2fwww.xcite.com%2f/RK=2/RS=oVoQuQuveUqgr_SRKn8WVsubJ6A-")));
                }
                else if(i==2){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://r.search.yahoo.com/_ylt=AwrFPyVY9Rhj1jIA0tVXNyoA;_ylu=Y29sbwNiZjEEcG9zAzEEdnRpZAMEc2VjA3Ny/RV=2/RE=1662608857/RO=10/RU=https%3a%2f%2fwww.xcite.com%2f/RK=2/RS=oVoQuQuveUqgr_SRKn8WVsubJ6A-")));
                }
                else if(i==3){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://r.search.yahoo.com/_ylt=AwrFcrKV9Rhj9jIAHcBXNyoA;_ylu=Y29sbwNiZjEEcG9zAzEEdnRpZAMEc2VjA3Ny/RV=2/RE=1662608917/RO=10/RU=https%3a%2f%2fwww.amazon.com%2f/RK=2/RS=CzhqHLmrfUYcf8GBZZ_UaDry2dU-")));
                }
                else if(i==4){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://r.search.yahoo.com/cbclk2/dWU9OEYwMzRCMTgzMkY5NDIxNCZ1dD0xNjYyNTgwMDA2ODU1JnVvPTc3NjUzMjAwNzI4NTA3Jmx0PTImcz0xJmVzPVREdjkzYUlHUFM5Q1hONFBZM0JXUUpsVmlXd1NGMnprTDN3RG9uZ29HdDVIR0lqcWU2by0-/RV=2/RE=1662608807/RO=10/RU=https%3a%2f%2fwww.bing.com%2faclick%3fld%3de8hE0Un7ODowbado0krOvnejVUCUw-yHc7f1qD5mOuixYPMAmhz_4wVgWTDOxQz_cr_v35ueyO4eg_oC-MXMeGoicxpt2tDmtetL5L9sHF-wlVStbvLZhzBBLgklATh0zNuvpUQG7q2tf_V9fQwzYMhE1AF6LdhnRr8FCDLUmZYWsi2QwbSk9eJOdM_l8S3jpfT7zUnw%26u%3daHR0cHMlM2ElMmYlMmZjbGlja3NlcnZlLmRhcnRzZWFyY2gubmV0JTJmbGluayUyZmNsaWNrJTNmbGlkJTNkNDM3MDAwNDkzNDQzNzExMDklMjZkc19zX2t3Z2lkJTNkNTg3MDAwMDU0MjA3NDc3NDglMjZkc19hX2NpZCUzZDQwNTU0NzkwNyUyNmRzX2FfY2FpZCUzZDkyMTg2OTczMDglMjZkc19hX2FnaWQlM2Q5NTE2NjY5MjA4NCUyNmRzX2FfbGlkJTNka3dkLTEwMDUyNzgxJTI2JTI2ZHNfZV9hZGlkJTNkNzc2NTMyMDA3Mjg1MDclMjZkc19lX3RhcmdldF9pZCUzZGt3ZC03NzY1MzI3NDEzOTA4NCUzYWxvYy00MDk3JTI2JTI2ZHNfZV9uZXR3b3JrJTNkbyUyNmRzX3VybF92JTNkMiUyNmRzX2Rlc3RfdXJsJTNkaHR0cHMlM2ElMmYlMmZ3d3cucmF5LWJhbi5jb20lMmZ1c2ElMmZzdW5nbGFzc2VzJTJmdmlldy1hbGwlM2ZjaWQlM2RQTS1TQklfMzAwNDE5LTEuVVMtUmF5QmFuLUVOLUItQ29yZS1FeGFjdF9UTS1BbGxfcmF5JTJiYmFuJTI2Z2NsaWQlM2RmMDA2ZTU3ZTZhMDYxN2Q3NjY4Mzg2NjY5ZjIxYmNjMyUyNmdjbHNyYyUzZDNwLmRzJTI2JTI2Y2lkJTNkUE0tU0JJXzAwMDAwMC0xLlVTLVJheUJhbi1FTi1CLUNvcmUtRXhhY3RfVE0tQWxsX3JheSUyYmJhbiUyNm1zY2xraWQlM2RmMDA2ZTU3ZTZhMDYxN2Q3NjY4Mzg2NjY5ZjIxYmNjMw%26rlid%3df006e57e6a0617d7668386669f21bcc3/RK=2/RS=lxYwup8SHvXsrZlii1BRVMZu3QY-;_ylt=AwrFPyUm9RhjtxUBV21XNyoA;_ylu=Y29sbwNiZjEEcG9zAzEEdnRpZAMEc2VjA292LXRvcA--;_ylc=X3IDMgRydAMw?IG=0ac53f254e4b447f8b0000000037f44f")));
                }
                else if(i==5){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://r.search.yahoo.com/cbclk2/dWU9NDdEMDVDMjlFQ0RFNDEyQSZ1dD0xNjYyNTc5OTExNTU2JnVvPTc3NzkwNjQ2NjMyMTk5Jmx0PTImcz0xJmVzPS42MVU0a2NHUFNfZWJLNWZySDFqQ1dGRWRYYzR3Z3dwWnNOdW5sc2FFZWtTb3o0cW1BLS0-/RV=2/RE=1662608711/RO=10/RU=https%3a%2f%2fwww.bing.com%2faclick%3fld%3de8jZxhni5l4YPdsk8BmPo5kTVUCUxMq6uLw55BNI0OKK_JFXnTz2knFWT4VLXVqKE1LeNlpKRd5LGNl0hhDMfZ6TUXOMxmvQTnXUsYM_PJMwZPmqgCqZ_xpXUDA4-iofeKhfv-NJMrVfUspG_c1FlRP23PD9NYjVmQq0nqhJbYYzRFFXTZrI_bHBFBNQkngUpmhEs6Vw%26u%3daHR0cHMlM2ElMmYlMmZ3d3cuYXBwbGUuY29tJTJmYXBwbGUtZXZlbnRzJTNmY2lkJTNkd3dhLXVzLWt3YmktZmVhdHVyZXMtc2xpZC0tQnJhbmQtYXBwbGVsaXZlLXBvc3QtJTI2bXRpZCUzZDIwOTI1ZTF0MzkxNjklMjZhb3NpZCUzZHAyMzglMjZtbmlkJTNkMnplM2RPZWwtZGNfbXRpZF8yMDkyNWUxdDM5MTY5X3BjcmlkXzc3NzkwNjQ2NjMyMTk5X3BncmlkXzEyNDQ2NDc3NTEwODg4MzRf%26rlid%3d12643b306de91ad2806b5828992edd13/RK=2/RS=K5gfT2W1rRHYenaeFENrZI8I5eI-;_ylt=AwrEmMfH9BhjW8cANNdXNyoA;_ylu=Y29sbwNiZjEEcG9zAzEEdnRpZAMEc2VjA292LXRvcA--;_ylc=X3IDMgRydAMw?IG=0ac498c7690a4921940000000059c551")));
                }
                else if(i==6){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://r.search.yahoo.com/_ylt=AwrFcrKV9Rhj9jIAHcBXNyoA;_ylu=Y29sbwNiZjEEcG9zAzEEdnRpZAMEc2VjA3Ny/RV=2/RE=1662608917/RO=10/RU=https%3a%2f%2fwww.amazon.com%2f/RK=2/RS=CzhqHLmrfUYcf8GBZZ_UaDry2dU-")));
                }
                else if(i==7){
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://r.search.yahoo.com/cbclk2/dWU9RDA3RkJGRTVENzdFNEQ3OCZ1dD0xNjYyNTgwMTgzNzQwJnVvPTg0OTM3NTYwMDk2MTkzJmx0PTImcz0xJmVzPUJOZ05uVzRHUFM5WXhzNHZJOTdDVlkxM3hUd051SlpLQV9lZDNyZTNNZXRMVURmQXZnLS0-/RV=2/RE=1662608984/RO=10/RU=https%3a%2f%2fwww.bing.com%2faclick%3fld%3de8Z2A356Aj16cghVeqYbremjVUCUxZEnjAvMNpRUQ9tKUim-NWg9Jnq-xK6E81mCwJt2nEUBwGhMtXlAQnF9D7XHMHiSNSvwz9iP1UKCgd9WzlUHKZB_Lns9dKJHfXdy25NjcLVz7dEYB6k97YD_3CM7zyCuUt_BxyZgMuDQPZkQILJOieCEWMK829axQDqsf3ZW1tJA%26u%3daHR0cHMlM2ElMmYlMmZ3d3cuZWJheS5jb20lMmZzY2glMmZpLmh0bWwlM2Zfbmt3JTNkcm9sZXglMjUyMHdhdGNoZXMlMjUyMG9ubGluZSUyNnJ0JTNkbmMlMjZMSF9BViUzZDElMjZub3JvdmVyJTNkMSUyNm1rZXZ0JTNkMSUyNm1rcmlkJTNkNzExLTE2MDAyMC04NjA1NTYtMyUyNm1rY2lkJTNkMiUyNmtleXdvcmQlM2Ryb2xleCUyNTIwd2F0Y2hlcyUyNTIwb25saW5lJTI2Y3JscCUzZF8lMjZNVF9JRCUzZCUyNmdlb19pZCUzZCUyNnJsc2F0YXJnZXQlM2Rrd2QtODQ5Mzc3MzYwOTYyNjUlM2Fsb2MtMTkwJTI2YWRwb3MlM2QlMjZkZXZpY2UlM2RjJTI2bWt0eXBlJTNkJTI2bG9jJTNkODU3MDAlMjZwb2klM2QlMjZhYmNJZCUzZCUyNmNtcGduJTNkNDEzMDA1MTI3JTI2c2l0ZWxuayUzZCUyNmFkZ3JvdXBpZCUzZDEzNTg5OTcxODU4Njc3NzAlMjZuZXR3b3JrJTNkbyUyNm1hdGNodHlwZSUzZHAlMjZtc2Nsa2lkJTNkNWYzYWQwNTg4ODRhMThkZmUxZWZiMzQwN2Q5MmMxZTE%26rlid%3d5f3ad058884a18dfe1efb3407d92c1e1/RK=2/RS=FQe0qDPdYZei2CMqdGRQ7ZdUk6E-;_ylt=AwrEoM3X9RhjJQUBkjFXNyoA;_ylu=Y29sbwNiZjEEcG9zAzEEdnRpZAMEc2VjA292LXRvcA--;_ylc=X3IDMgRydAMw?IG=0ac4a0cd52484e94ad00000000e2fa61")));
                }
            }
        });

        //animation
        hrs.setTranslationY(800);

        hrs.setAlpha(v);

        hrs.animate().translationY(0).alpha(1).setDuration(500).setStartDelay(400).start();

        //set...
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Store.this, Home_Screen.class);
                startActivity(intent);
            }
        });

//        donate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Store.this, Donate.class);
//                startActivity(intent);
//            }
//        });
    }
}