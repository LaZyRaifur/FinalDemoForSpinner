package com.example.raifu.finalforspinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.raifu.finalforspinner.Adapter.AddressAdapter;
import com.example.raifu.finalforspinner.Adapter.CityAdapter;
import com.example.raifu.finalforspinner.Extra.ExtraDetails;
import com.example.raifu.finalforspinner.Model.Address;
import com.example.raifu.finalforspinner.Model.City;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private List<Address> addressEntityList = new ArrayList<Address>();
    private List<City> cityEntityList = new ArrayList<City>();
    private ListView listView;
    private AddressAdapter adapter;
    private CityAdapter cityAdapter;
    private Spinner citySpinner;

    //extra implement for nothing
    Spinner spinnerCountry,spinnerDivision;
    ArrayAdapter<String> countryArray,divisionArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        citySpinner = (Spinner)findViewById(R.id.citySpinner);
        listView = (ListView) findViewById(R.id.address_listview);
        cityAdapter = new CityAdapter(this,android.R.layout.simple_spinner_dropdown_item,loadDummyCities());
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(cityAdapter);
        citySpinner.setOnItemSelectedListener(this);
        loadDummyAddress();
        adapter = new AddressAdapter(this, addressEntityList);
        listView.setAdapter(adapter);

        //Listview implement for extra class
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent extraIntent = new Intent(MainActivity.this,ExtraDetails.class);
                startActivity(extraIntent);
            }
        });

        //////////////////////////

        //extra for nothing
        spinnerCountry = (Spinner) findViewById(R.id.districtSpinner);
        //implementing OnItemSelectedListener (need to override the method)
        spinnerCountry.setOnItemSelectedListener(this);
        countryArray = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        countryArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(countryArray);
        //parent Spinner
        countryArray.add("Dhaka");
        countryArray.add("Gazipur");
        countryArray.add("Manikganj");
        countryArray.add("Munshiganj");
        countryArray.add("Narsingdi");
        countryArray.add("Tangail");
        countryArray.add("Kishoreganj");
        countryArray.add("Faridpur");
        countryArray.add("Gopalganj");
        countryArray.add("Rajbari");
        countryArray.add("Shariatpur");
        countryArray.setNotifyOnChange(true);
        spinnerCountry.setSelection(0);
        spinnerDivision = (Spinner) findViewById(R.id.citySpinner);
        //implementing OnItemSelectedListener (need to override the method)
        spinnerDivision.setOnItemSelectedListener(this);
        divisionArray = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        divisionArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDivision.setAdapter(divisionArray);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    private List<City> loadDummyCities(){
        cityEntityList = new ArrayList<City>();

        City city1 = new City();
        city1.setId(1);
        city1.setCity("Dhanmondi");
        cityEntityList.add(city1);
        City city2 = new City();
        city2.setId(2);
        city2.setCity("Motijheel");
        cityEntityList.add(city2);

        City city3 = new City();
        city3.setId(3);
        city3.setCity("Gulshan");
        cityEntityList.add(city3);

        City city4 = new City();
        city4.setId(4);
        city4.setCity("Banani");
        cityEntityList.add(city4);

        City city5 = new City();
        city5.setId(5);
        city5.setCity("Wari");
        cityEntityList.add(city5);

        City city6 = new City();
        city6.setId(6);
        city6.setCity("Bongshal");
        cityEntityList.add(city6);
        City city7 = new City();
        city7.setId(7);
        city7.setCity("Shahbagh");
        cityEntityList.add(city7);

        City city8 = new City();
        city8.setId(8);
        city8.setCity("Samoli");
        cityEntityList.add(city8);

        City city9 = new City();
        city9.setId(9);
        city9.setCity("Mirpur");
        cityEntityList.add(city9);

        City city10 = new City();
        city10.setId(10);
        city10.setCity("Savar");
        cityEntityList.add(city10);

        City city11 = new City();
        city11.setId(11);
        city11.setCity("Keranigonj");
        cityEntityList.add(city11);

        City city12 = new City();
        city12.setId(12);
        city12.setCity("Narayngonj");
        cityEntityList.add(city12);

        City city13 = new City();
        city13.setId(13);
        city13.setCity("Jatrabari");
        cityEntityList.add(city13);

        return cityEntityList;
    }

    private List<Address> loadDummyAddress(){

        addressEntityList = new ArrayList<Address>();

        //Dhanmondi
        Address address1 = new Address();
        address1.setId(1);
        address1.setCityId(1);
        address1.setArea("Dhanmondi");
        address1.setBuildingName("1");
        address1.setStreet("2nd");
        address1.setPhone("0000");
        addressEntityList.add(address1);
        Address address7 = new Address();
        address7.setId(1);
        address7.setCityId(1);
        address7.setArea("Dhanmondi");
        address7.setBuildingName("Kinfra");
        address7.setStreet("2nd");
        address7.setPhone("0000");
        addressEntityList.add(address7);

        Address address11 = new Address();
        address11.setId(1);
        address11.setCityId(1);
        address11.setArea("item11");
        address11.setBuildingName("Kinfra");
        address11.setStreet("2nd");
        address11.setPhone("0000");
        addressEntityList.add(address11);
        Address address12 = new Address();
        address12.setId(1);
        address12.setCityId(1);
        address12.setArea("item12");
        address12.setBuildingName("Kinfra");
        address12.setStreet("2nd");
        address12.setPhone("0000");
        addressEntityList.add(address12);
        Address address8 = new Address();
        address8.setId(1);
        address8.setCityId(1);
        address8.setArea("item8");
        address8.setBuildingName("Kinfra");
        address8.setStreet("2nd");
        address8.setPhone("0000");
        addressEntityList.add(address8);
        Address address9 = new Address();
        address9.setId(1);
        address9.setCityId(1);
        address9.setArea("item9");
        address9.setBuildingName("Kinfra");
        address9.setStreet("2nd");
        address9.setPhone("0000");
        addressEntityList.add(address9);
        Address address10 = new Address();
        address10.setId(1);
        address10.setCityId(1);
        address10.setArea("item10");
        address10.setBuildingName("Kinfra");
        address10.setStreet("2nd");
        address10.setPhone("0000");
        addressEntityList.add(address10);
        Address address13 = new Address();
        address13.setId(1);
        address13.setCityId(1);
        address13.setArea("item11");
        address13.setBuildingName("Kinfra");
        address13.setStreet("2nd");
        address13.setPhone("0000");
        addressEntityList.add(address13);

        Address address4 = new Address();
        address4.setId(4);
        address4.setCityId(4);
        address4.setArea("Banani");
        address4.setBuildingName("Building");
        address4.setStreet("street for address");
        address4.setPhone("000");
        addressEntityList.add(address4);


        Address address2 = new Address();

        address2.setId(2);
        address2.setCityId(2);
        address2.setArea("Motijheel");
        address2.setBuildingName("Sharmi");
        address2.setStreet("2nd Cross");
        address2.setPhone("0000");
        addressEntityList.add(address2);

        Address address6 = new Address();
        address6.setId(6);
        address6.setCityId(6);
        address6.setArea("Gulshan");
        address6.setBuildingName("Sharmi");
        address6.setStreet("2nd Cross");
        address6.setPhone("0000");
        addressEntityList.add(address6);

        Address address3 = new Address();
        address3.setId(3);
        address3.setCityId(3);
        address3.setArea("Gulshan");
        address3.setBuildingName("Carlton");
        address3.setStreet("Church Street");
        address3.setPhone("0099");
        addressEntityList.add(address3);

        Address address5 = new Address();
        address5.setId(5);
        address5.setCityId(5);
        address5.setArea("Wari");
        address5.setBuildingName("New");
        address5.setStreet("Vatanappilly");
        address5.setPhone("009");
        addressEntityList.add(address5);

        return addressEntityList;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        City city = cityAdapter.getItem(position);

//Here we use the Filtering Feature which we implemented in our Adapter class.
        adapter.getFilter().filter(Long.toString(city.getId()), new Filter.FilterListener() {
            @Override
            public void onFilterComplete(int count) {


            }
        });


        //extra for nothing

        int DistrictPosition = spinnerCountry.getSelectedItemPosition();
        switch (DistrictPosition) {
            case 0:
                fillDhaka();
                break;
            case 1:
                fillGazipur();
                break;
            case 2:
                fillManikganj();
                break;
            case 3:
                fillMunshiganj();
                break;
            case 4:
                fillNarsingdi();
                break;
            case 5:
                fillTangail();
                break;
            case 6:
                fillKishorganj();
                break;
            case 7:
                fillFraidpur();
                break;
            case 8:
                fillGopalganj();
                break;
            case 9:
                fillRajbari();
                break;
            case 10:
                fillShariatpur();
                break;

        }
    }
        //extra for nothing

        private void fillKishorganj() {
            divisionArray.clear();

            divisionArray.add("Demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.notifyDataSetChanged();
        }

        private void fillGopalganj() {
            divisionArray.clear();

            divisionArray.add("Demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.notifyDataSetChanged();
        }

        private void fillRajbari() {
            divisionArray.clear();

            divisionArray.add("Demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.notifyDataSetChanged();
        }

        private void fillShariatpur() {
            divisionArray.clear();

            divisionArray.add("Demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.notifyDataSetChanged();
        }

        private void fillFraidpur() {
            divisionArray.clear();

            divisionArray.add("Demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.notifyDataSetChanged();
        }

        private void fillTangail() {
            divisionArray.clear();

            divisionArray.add("Demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.notifyDataSetChanged();
        }

        private void fillNarsingdi()
        {
            divisionArray.clear();

            divisionArray.add("Demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.notifyDataSetChanged();
        }

        private void fillMunshiganj() {
            divisionArray.clear();
            divisionArray.add("Demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.add("demo");
            divisionArray.notifyDataSetChanged();
        }

        private void fillManikganj() {
            divisionArray.clear();
            divisionArray.add("Rajibpur");
            divisionArray.add("Krishnapur");
            divisionArray.add("Mokimpur");
            divisionArray.add("Gazipara");
            divisionArray.add("Barahirchar");
            divisionArray.add("Barai vikora");
            divisionArray.add("Guzuri");
            divisionArray.add("Motto");
            divisionArray.add("Diyara vabanipur");
            divisionArray.add("katikgram");
            divisionArray.add("Terodona");
            divisionArray.notifyDataSetChanged();
        }

        private void fillGazipur() {
            divisionArray.clear();
            divisionArray.add("Gazipur Sadar");
            divisionArray.add("Kaliakar");
            divisionArray.add("Kapasia");
            divisionArray.add("Sreepur");
            divisionArray.add("Kaliganj");
            divisionArray.add("Gazipur City Corporation");

            divisionArray.notifyDataSetChanged();
        }

        private void fillDhaka() {
            divisionArray.clear();
            divisionArray.add("Dhanmondi");
            divisionArray.add("Motijheel");
            divisionArray.add("Gulshan");
            divisionArray.add("Banani");
            divisionArray.add("Wari");
            divisionArray.add("Bongshal");
            divisionArray.add("Shahbagh");
            divisionArray.add("Samoli");
            divisionArray.add("Mirpur");
            divisionArray.add("Savar");
            divisionArray.add("Keranigonj");
            divisionArray.add("Narayangonj");
            divisionArray.add("Jatrabari");

            divisionArray.notifyDataSetChanged();
        }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }




//
//    private List<Address> addressEntityList = new ArrayList<Address>();
//    private List<City> cityEntityList = new ArrayList<City>();
//    private ListView listView;
//    private AddressAdapter adapter;
//    private CityAdapter cityAdapter;
//    private Spinner citySpinner,districtSpinner;
//    ArrayAdapter<String>districtArray,AreaArray;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        citySpinner = (Spinner)findViewById(R.id.citySpinner);
//        listView = (ListView) findViewById(R.id.address_listview);
//
//        //extra
//        districtSpinner = findViewById(R.id.districtSpinner);
//        districtSpinner.setOnItemSelectedListener(this);
//
//        districtArray = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
//        districtArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        districtSpinner.setAdapter(districtArray);
//
//        //parent Spinner
//        districtArray.add("Dhaka");
//        districtArray.add("Gazipur");
//        districtArray.add("Manikganj");
//        districtArray.add("Munshiganj");
//        districtArray.add("Narsingdi");
//        districtArray.add("Tangail");
//        districtArray.add("Kishoreganj");
//        districtArray.add("Faridpur");
//        districtArray.add("Gopalganj");
//        districtArray.add("Rajbari");
//        districtArray.add("Shariatpur");
//        districtArray.setNotifyOnChange(true);
//
//        districtSpinner.setSelection(0);
//
//
//
//        cityAdapter = new CityAdapter(this,android.R.layout.simple_spinner_dropdown_item,loadDummyCities());
//        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        citySpinner.setAdapter(cityAdapter);
//        citySpinner.setOnItemSelectedListener(this);
//        loadDummyAddress();
//        adapter = new AddressAdapter(this, addressEntityList);
//        listView.setAdapter(adapter);
//
//        //extra for nothing
//        districtSpinner = findViewById(R.id.districtSpinner);
//        districtSpinner.setOnItemSelectedListener(this);
//        AreaArray = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
//        AreaArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        districtSpinner.setAdapter(AreaArray);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
////        if (id == R.id.action_settings) {
////            return true;
////        }
//
//        return super.onOptionsItemSelected(item);
//    }
//
//    private List<City> loadDummyCities(){
//        cityEntityList = new ArrayList<City>();
//
//        City city1 = new City();
//        city1.setId(1);
//        city1.setCity("Kochi");
//        cityEntityList.add(city1);
//        City city2 = new City();
//        city2.setId(2);
//        city2.setCity("Bangalore");
//        cityEntityList.add(city2);
//        City city3 = new City();
//        city3.setId(3);
//        city3.setCity("Delhi");
//        cityEntityList.add(city3);
//
//        return cityEntityList;
//    }
//
//    private List<Address> loadDummyAddress(){
//
//        addressEntityList = new ArrayList<Address>();
//        Address address1 = new Address();
//        address1.setId(1);
//        address1.setCityId(1);
//        address1.setArea("Kalamassery");
//        address1.setBuildingName("Kinfra");
//        address1.setStreet("2nd");
//        addressEntityList.add(address1);
//
//        Address address2 = new Address();
//        address2.setId(2);
//        address2.setCityId(2);
//        address2.setArea("Banaswadi");
//        address2.setBuildingName("Sharmi");
//        address2.setStreet("2nd Cross");
//        addressEntityList.add(address2);
//
//        Address address3 = new Address();
//        address3.setId(3);
//        address3.setCityId(2);
//        address3.setArea("MG Road");
//        address3.setBuildingName("Carlton");
//        address3.setStreet("Church Street");
//        addressEntityList.add(address3);
//
//        Address address4 = new Address();
//        address4.setId(4);
//        address4.setCityId(1);
//        address4.setArea("Thrissur");
//        address4.setBuildingName("New");
//        address4.setStreet("Vatanappilly");
//        addressEntityList.add(address4);
//
//        return addressEntityList;
//    }
//
//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        //first spinner item position
//        int countrySpinnerPosition = districtSpinner.getSelectedItemPosition();
//        switch (countrySpinnerPosition){
//            case 0:
//                //fill data for second spinner
//                loadDummyCities();
//                break;
//            case 1:
//                //fill data for second spinner
//                loadDummyCities();
//                break;
//            case 2:
//                //fill data for second spinner
//                loadDummyCities();
//                break;
//            case 3:
//                //fill data for second spinner
//                loadDummyCities();
//                break;
//        }
//
//        City city = cityAdapter.getItem(position);
//
////Here we use the Filtering Feature which we implemented in our Adapter class.
//        adapter.getFilter().filter(Long.toString(city.getId()),new Filter.FilterListener() {
//            @Override
//            public void onFilterComplete(int count) {
//
//            }
//        });
//    }
//    private void fillBangladeshDivision() {
//        AreaArray.clear();
//       AreaArray.add("Dhaka");
//        AreaArray.add("Chittagong");
//        AreaArray.add("Rangpur");
//        AreaArray.add("Rajshahi");
//        AreaArray.add("Sylhet");
//        AreaArray.notifyDataSetChanged();
//    }
//
//    private void fillIndiaDivision() {
//        AreaArray.clear();
//        AreaArray.add("Aurangabad");
//        AreaArray.add("Amravati");
//        AreaArray.add("Konkan");
//        AreaArray.add("Nagpur");
//        AreaArray.notifyDataSetChanged();
//    }
//
//    private void fillUSADivision() {
//        AreaArray.clear();
//        AreaArray.add("Boston");
//        AreaArray.add("New York");
//        AreaArray.add("Richmond");
//        AreaArray.notifyDataSetChanged();
//    }
//
//    private void fillCanadaDivision(){
//        AreaArray.clear();
//        AreaArray.add("Quebec");
//        AreaArray.add("Ontario");
//        AreaArray.notifyDataSetChanged();
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }
}