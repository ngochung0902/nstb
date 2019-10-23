package com.app.langta.niemsotribenh.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.app.langta.niemsotribenh.R;
import com.app.langta.niemsotribenh.fragment.Frm_sothunghiem;
import com.app.langta.niemsotribenh.fragment.Frm_sotribenh;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;
import java.util.Objects;

public class Home extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;
    ViewPager vpg_home;
    EditText edt_timkiem;
    View view_sothunghiem, view_sotribenh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        vpg_home = findViewById(R.id.vpg_home);
        view_sothunghiem = findViewById(R.id.view_sothunghiem);
        view_sotribenh = findViewById(R.id.view_sotribenh);
        MyPagerAdapter adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        vpg_home.setAdapter(adapterViewPager);
        vpg_home.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position==0){
                    view_sothunghiem.setVisibility(View.GONE);
                    view_sotribenh.setVisibility(View.VISIBLE);
                }else {
                    view_sothunghiem.setVisibility(View.VISIBLE);
                    view_sotribenh.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        edt_timkiem = findViewById(R.id.edt_timkiem);
        edt_timkiem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (vpg_home.getCurrentItem()==0){
                    Frm_sotribenh frag = (Frm_sotribenh) Objects.requireNonNull(vpg_home.getAdapter()).instantiateItem(vpg_home, 0);
                    frag.timKiem(s.toString());
                }
            }
        });

    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 2;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return Frm_sotribenh.newInstance(0, "Page # 1");
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return Frm_sothunghiem.newInstance(1, "Page # 2");
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

    }


    private void addData() {
        myRef.child("1").child("DoLinhNghiem").setValue(0);
        myRef.child("1").child("GhiChu").setValue("-");
        myRef.child("1").child("SoBenh").setValue("120060");
        myRef.child("1").child("TenBenh").setValue("Amidan");

        myRef.child("2").child("DoLinhNghiem").setValue(0);
        myRef.child("2").child("GhiChu").setValue("-");
        myRef.child("2").child("SoBenh").setValue("650.300");
        myRef.child("2").child("TenBenh").setValue("Bong võng mạc");

        myRef.child("3").child("DoLinhNghiem").setValue(0);
        myRef.child("3").child("GhiChu").setValue("-");
        myRef.child("3").child("SoBenh").setValue("80 | 800 | 38 | 380");
        myRef.child("3").child("TenBenh").setValue("Béo phì");

        myRef.child("4").child("DoLinhNghiem").setValue(0);
        myRef.child("4").child("GhiChu").setValue("-");
        myRef.child("4").child("SoBenh").setValue("08.206005 | 08.206000");
        myRef.child("4").child("TenBenh").setValue("Bướu cổ, cường tuyến giáp");

        myRef.child("5").child("DoLinhNghiem").setValue(0);
        myRef.child("5").child("GhiChu").setValue("-");
        myRef.child("5").child("SoBenh").setValue("1650 | 10650");
        myRef.child("5").child("TenBenh").setValue("Bại liệt bàn chân trái");

        myRef.child("6").child("DoLinhNghiem").setValue(0);
        myRef.child("6").child("GhiChu").setValue("-");
        myRef.child("6").child("SoBenh").setValue("650 | 6500 | 820");
        myRef.child("6").child("TenBenh").setValue("Bệnh gan, nám da mặt");

        myRef.child("7").child("DoLinhNghiem").setValue(0);
        myRef.child("7").child("GhiChu").setValue("Mùa xuân qua hè đọc: 4000.820 | Mùa thu đông đọc: 4000.370");
        myRef.child("7").child("SoBenh").setValue("4000.820 | 4000.370");
        myRef.child("7").child("TenBenh").setValue("Bệnh Gout");


        myRef.child("8").child("DoLinhNghiem").setValue(0);
        myRef.child("8").child("GhiChu").setValue("-");
        myRef.child("8").child("SoBenh").setValue("Tập dịch cân kinh");
        myRef.child("8").child("TenBenh").setValue("Bệnh Parkinson");
        myRef.child("8").child("url_image").setValue("https://firebasestorage.googleapis.com/v0/b/niemsotribenh.appspot.com/o/ghichu7.jpg?alt=media&token=5580be79-65bf-4609-a4a7-1d6484be0b50");

        myRef.child("9").child("DoLinhNghiem").setValue(0);
        myRef.child("9").child("GhiChu").setValue("-");
        myRef.child("9").child("SoBenh").setValue("206 | 2006");
        myRef.child("9").child("TenBenh").setValue("Bệnh sởi");

        myRef.child("10").child("DoLinhNghiem").setValue(0);
        myRef.child("10").child("GhiChu").setValue("-");
        myRef.child("10").child("SoBenh").setValue("260.0060 | 26.00.00");
        myRef.child("10").child("TenBenh").setValue("Bệnh Vẩy nến");

        myRef.child("11").child("DoLinhNghiem").setValue(0);
        myRef.child("11").child("GhiChu").setValue("-");
        myRef.child("11").child("SoBenh").setValue("71000");
        myRef.child("11").child("TenBenh").setValue("Bệnh đái dầm trẻ em");

        myRef.child("12").child("DoLinhNghiem").setValue(0);
        myRef.child("12").child("GhiChu").setValue("-");
        myRef.child("12").child("SoBenh").setValue("710000");
        myRef.child("12").child("TenBenh").setValue("Bệnh đường tiết niệu (Đi tiểu xong vẫn có nước tiểu rỉ)");

        myRef.child("13").child("DoLinhNghiem").setValue(0);
        myRef.child("13").child("GhiChu").setValue("-");
        myRef.child("13").child("SoBenh").setValue("003 | 0003 | 30 300 | 3000");
        myRef.child("13").child("TenBenh").setValue("Bỏng hoặc đau mắt");

        myRef.child("14").child("DoLinhNghiem").setValue(0);
        myRef.child("14").child("GhiChu").setValue("-");
        myRef.child("14").child("SoBenh").setValue("1000");
        myRef.child("14").child("TenBenh").setValue("Bổ sung canxi (tăng chiều cao trẻ nhỏ)");

        myRef.child("15").child("DoLinhNghiem").setValue(0);
        myRef.child("15").child("GhiChu").setValue("-");
        myRef.child("15").child("SoBenh").setValue("30 | 300 | 3000 | 20060 | 200600 | 60.20 | 600.200");
        myRef.child("15").child("TenBenh").setValue("Cai thuốc lá");

        myRef.child("16").child("DoLinhNghiem").setValue(0);
        myRef.child("16").child("GhiChu").setValue("Lấy tay rờ bé, dùng ấn Cát Tường và thử đọc 20,00,60 hoặc 60430");
        myRef.child("16").child("SoBenh").setValue("20,00,60 | 60430");
        myRef.child("16").child("TenBenh").setValue("Cho bé ngủ sớm dậy sớm");

        myRef.child("17").child("DoLinhNghiem").setValue(0);
        myRef.child("17").child("GhiChu").setValue("-");
        myRef.child("17").child("SoBenh").setValue("12 | 120 | 21 | 210");
        myRef.child("17").child("TenBenh").setValue("Chuột rút");

        myRef.child("18").child("DoLinhNghiem").setValue(0);
        myRef.child("18").child("GhiChu").setValue("-");
        myRef.child("18").child("SoBenh").setValue("20 | 200 | 2006 | 20006");
        myRef.child("18").child("TenBenh").setValue("Cảm lạnh");

        myRef.child("19").child("DoLinhNghiem").setValue(0);
        myRef.child("19").child("GhiChu").setValue("-");
        myRef.child("19").child("SoBenh").setValue("120060");
        myRef.child("19").child("TenBenh").setValue("Cảm sốt");

        myRef.child("20").child("DoLinhNghiem").setValue(0);
        myRef.child("20").child("GhiChu").setValue("Nếu hoả nhiều diệt thuỷ thì: 2605 hay 26005; Nếu thuỷ nhiều diệt hoả thì: 6530 hoặc 65300");
        myRef.child("20").child("SoBenh").setValue("2605 | 26005 | 6530 | 65300");
        myRef.child("20").child("TenBenh").setValue("Cận thị");

        myRef.child("21").child("DoLinhNghiem").setValue(0);
        myRef.child("21").child("GhiChu").setValue("-");
        myRef.child("21").child("SoBenh").setValue("200.6000");
        myRef.child("21").child("TenBenh").setValue("Da đen muốn trắng");

        myRef.child("22").child("DoLinhNghiem").setValue(0);
        myRef.child("22").child("GhiChu").setValue("-");
        myRef.child("22").child("SoBenh").setValue("260 | 200600");
        myRef.child("22").child("TenBenh").setValue("Da đen và nhiều mụn");

        myRef.child("23").child("DoLinhNghiem").setValue(0);
        myRef.child("23").child("GhiChu").setValue("-");
        myRef.child("23").child("SoBenh").setValue("820");
        myRef.child("23").child("TenBenh").setValue("Dễ bị trúng thực, bao tử yếu");

        myRef.child("24").child("DoLinhNghiem").setValue(0);
        myRef.child("24").child("GhiChu").setValue("-");
        myRef.child("24").child("SoBenh").setValue("206");
        myRef.child("24").child("TenBenh").setValue("Dị ứng da đầu bị mọc mụn");

        myRef.child("25").child("DoLinhNghiem").setValue(0);
        myRef.child("25").child("GhiChu").setValue("-");
        myRef.child("25").child("SoBenh").setValue("260 | 002 | 0026 | 00260 | 00026");
        myRef.child("25").child("TenBenh").setValue("Dị ứng ngứa người");

        myRef.child("26").child("DoLinhNghiem").setValue(0);
        myRef.child("26").child("GhiChu").setValue("-");
        myRef.child("26").child("SoBenh").setValue("206 | 2060");
        myRef.child("26").child("TenBenh").setValue("Dị ứng phấn hoa");

        myRef.child("27").child("DoLinhNghiem").setValue(0);
        myRef.child("27").child("GhiChu").setValue("-");
        myRef.child("27").child("SoBenh").setValue("030");
        myRef.child("27").child("TenBenh").setValue("Gan nhiễm mỡ");

        myRef.child("28").child("DoLinhNghiem").setValue(0);
        myRef.child("28").child("GhiChu").setValue("-");
        myRef.child("28").child("SoBenh").setValue("640 | 6400 | 6040 | 60400 | 650");
        myRef.child("28").child("TenBenh").setValue("Gan yếu muốn mạnh");

        myRef.child("29").child("DoLinhNghiem").setValue(0);
        myRef.child("29").child("GhiChu").setValue("-");
        myRef.child("29").child("SoBenh").setValue("2650380");
        myRef.child("29").child("TenBenh").setValue("Giảm cân");

        myRef.child("30").child("DoLinhNghiem").setValue(0);
        myRef.child("30").child("GhiChu").setValue("Đọc từng cặp");
        myRef.child("30").child("SoBenh").setValue("20-00-06 | 20-00-60");
        myRef.child("30").child("TenBenh").setValue("Hen suyễn");

        myRef.child("31").child("DoLinhNghiem").setValue(0);
        myRef.child("31").child("GhiChu").setValue("-");
        myRef.child("31").child("SoBenh").setValue("120060");
        myRef.child("31").child("TenBenh").setValue("Amidan");

        myRef.child("32").child("DoLinhNghiem").setValue(0);
        myRef.child("32").child("GhiChu").setValue("-");
        myRef.child("32").child("SoBenh").setValue("206 | 2006 | 200060");
        myRef.child("32").child("TenBenh").setValue("Ho khan");

        myRef.child("33").child("DoLinhNghiem").setValue(0);
        myRef.child("33").child("GhiChu").setValue("-");
        myRef.child("33").child("SoBenh").setValue("3820 | 38200 | 260043 | 260053");
        myRef.child("33").child("TenBenh").setValue("Huyết áp cao muốn giảm");

        myRef.child("34").child("DoLinhNghiem").setValue(0);
        myRef.child("34").child("GhiChu").setValue("-");
        myRef.child("34").child("SoBenh").setValue("43 | 53 | 430 | 530");
        myRef.child("34").child("TenBenh").setValue("Huyết áp thấp muốn tăng");

        myRef.child("35").child("DoLinhNghiem").setValue(0);
        myRef.child("35").child("GhiChu").setValue("Hóc xương cá thì tìm trong nhà hay trước nhà có cây nào nằm ngang thì dùng chân hay tay để nó thẳng lại sẽ hết.");
        myRef.child("35").child("SoBenh").setValue("620");
        myRef.child("35").child("TenBenh").setValue("Hóc xương cá");

        myRef.child("36").child("DoLinhNghiem").setValue(0);
        myRef.child("36").child("GhiChu").setValue("-");
        myRef.child("36").child("SoBenh").setValue("800,05 | 80,00,05 | 643800 | 6438200");
        myRef.child("36").child("TenBenh").setValue("Hôi miệng");

        myRef.child("37").child("DoLinhNghiem").setValue(0);
        myRef.child("37").child("GhiChu").setValue("-");
        myRef.child("37").child("SoBenh").setValue("43820 | 380");
        myRef.child("37").child("TenBenh").setValue("Hôi nách");

        myRef.child("38").child("DoLinhNghiem").setValue(0);
        myRef.child("38").child("GhiChu").setValue("-");
        myRef.child("38").child("SoBenh").setValue("64380.120600 | 65380.120600");
        myRef.child("38").child("TenBenh").setValue("Hạ đường huyết tiểu đường, trị mắt cườm hay mắt nổi tia máu đỏ (Viêm mắt)");

        myRef.child("39").child("DoLinhNghiem").setValue(0);
        myRef.child("39").child("GhiChu").setValue("-");
        myRef.child("39").child("SoBenh").setValue("206");
        myRef.child("39").child("TenBenh").setValue("Hắt hơi, chảy máu mũi, dị ứng do thời tiết");

        myRef.child("40").child("DoLinhNghiem").setValue(0);
        myRef.child("40").child("GhiChu").setValue("-");
        myRef.child("40").child("SoBenh").setValue("2060");
        myRef.child("40").child("TenBenh").setValue("Khịt mũi, khò khè");

        myRef.child("41").child("DoLinhNghiem").setValue(0);
        myRef.child("41").child("GhiChu").setValue("-");
        myRef.child("41").child("SoBenh").setValue("60 | 600 | 6000 | 605 | 6050 | 6005 | 600050");
        myRef.child("41").child("TenBenh").setValue("Kinh nguyệt không đều");

        myRef.child("42").child("DoLinhNghiem").setValue(0);
        myRef.child("42").child("GhiChu").setValue("-");
        myRef.child("42").child("SoBenh").setValue("650300");
        myRef.child("42").child("TenBenh").setValue("Kinh nguyệt ít");

        myRef.child("43").child("DoLinhNghiem").setValue(0);
        myRef.child("43").child("GhiChu").setValue("-");
        myRef.child("43").child("SoBenh").setValue("1000 | 10006 | 100060 | 7100060 | 820 | 650");
        myRef.child("43").child("TenBenh").setValue("Kích thích ăn uống (do ăn không được hoặc người gầy)");

        myRef.child("44").child("DoLinhNghiem").setValue(0);
        myRef.child("44").child("GhiChu").setValue("-");
        myRef.child("44").child("SoBenh").setValue("8200 | 38200");
        myRef.child("44").child("TenBenh").setValue("Kích thích ăn uống cho trẻ nhỏ không ăn nhiều");

        myRef.child("45").child("DoLinhNghiem").setValue(0);
        myRef.child("45").child("GhiChu").setValue("-");
        myRef.child("45").child("SoBenh").setValue("200006 | 200060");
        myRef.child("45").child("TenBenh").setValue("Lao phổi, viêm gân vai tay");

        myRef.child("46").child("DoLinhNghiem").setValue(0);
        myRef.child("46").child("GhiChu").setValue("-");
        myRef.child("46").child("SoBenh").setValue("6438200");
        myRef.child("46").child("TenBenh").setValue("Loét bao tử hay viêm");

        myRef.child("47").child("DoLinhNghiem").setValue(0);
        myRef.child("47").child("GhiChu").setValue("-");
        myRef.child("47").child("SoBenh").setValue("643820");
        myRef.child("47").child("TenBenh").setValue("Lạnh bụng dưới (lạnh tử cung)");

        myRef.child("48").child("DoLinhNghiem").setValue(0);
        myRef.child("48").child("GhiChu").setValue("-");
        myRef.child("48").child("SoBenh").setValue("6000");
        myRef.child("48").child("TenBenh").setValue("Mang bầu bị đau hông");

        myRef.child("49").child("DoLinhNghiem").setValue(0);
        myRef.child("49").child("GhiChu").setValue("-");
        myRef.child("49").child("SoBenh").setValue("8200600");
        myRef.child("49").child("TenBenh").setValue("Mất ngủ");

        myRef.child("50").child("DoLinhNghiem").setValue(0);
        myRef.child("50").child("GhiChu").setValue("-");
        myRef.child("50").child("SoBenh").setValue("03 | 003 | 0003");
        myRef.child("50").child("TenBenh").setValue("Mắt bị đau");

        myRef.child("51").child("DoLinhNghiem").setValue(0);
        myRef.child("51").child("GhiChu").setValue("-");
        myRef.child("51").child("SoBenh").setValue("008.206000");
        myRef.child("51").child("TenBenh").setValue("Mắt mờ do tiểu đường");

        myRef.child("52").child("DoLinhNghiem").setValue(0);
        myRef.child("52").child("GhiChu").setValue("-");
        myRef.child("52").child("SoBenh").setValue("120060");
        myRef.child("52").child("TenBenh").setValue("Amidan");

        myRef.child("53").child("DoLinhNghiem").setValue(0);
        myRef.child("53").child("GhiChu").setValue("-");
        myRef.child("53").child("SoBenh").setValue("206 | 2060 | 200600");
        myRef.child("53").child("TenBenh").setValue("Mắt nổi cườn (do nóng trong người)");

        myRef.child("54").child("DoLinhNghiem").setValue(0);
        myRef.child("54").child("GhiChu").setValue("-");
        myRef.child("54").child("SoBenh").setValue("200 | 2000 | 003 | 300");
        myRef.child("54").child("TenBenh").setValue("Mắt thâm");

        myRef.child("55").child("DoLinhNghiem").setValue(0);
        myRef.child("55").child("GhiChu").setValue("-");
        myRef.child("55").child("SoBenh").setValue("1206");
        myRef.child("55").child("TenBenh").setValue("Mọc răng cho trẻ");

        myRef.child("56").child("DoLinhNghiem").setValue(0);
        myRef.child("56").child("GhiChu").setValue("-");
        myRef.child("56").child("SoBenh").setValue("650 | 7200650");
        myRef.child("56").child("TenBenh").setValue("Mỏi cổ, cánh tay");

        myRef.child("57").child("DoLinhNghiem").setValue(0);
        myRef.child("57").child("GhiChu").setValue("-");
        myRef.child("57").child("SoBenh").setValue("530 | 5300 | 260 |2600");
        myRef.child("57").child("TenBenh").setValue("Mờ mắt sau sinh");

        myRef.child("58").child("DoLinhNghiem").setValue(0);
        myRef.child("58").child("GhiChu").setValue("-");
        myRef.child("58").child("SoBenh").setValue("650 | 6050");
        myRef.child("58").child("TenBenh").setValue("Mờ mắt, đục thuỷ tinh thể");

        myRef.child("59").child("DoLinhNghiem").setValue(0);
        myRef.child("59").child("GhiChu").setValue("-");
        myRef.child("59").child("SoBenh").setValue("620");
        myRef.child("59").child("TenBenh").setValue("Mỡ bụng phụ nữ");

        myRef.child("60").child("DoLinhNghiem").setValue(0);
        myRef.child("60").child("GhiChu").setValue("-");
        myRef.child("60").child("SoBenh").setValue("Có thể do thiếu vitamin ánh nắng mặt trời");
        myRef.child("60").child("TenBenh").setValue("Mụn li ti ở cổ");

        myRef.child("61").child("DoLinhNghiem").setValue(0);
        myRef.child("61").child("GhiChu").setValue("-");
        myRef.child("61").child("SoBenh").setValue("206 | 260");
        myRef.child("61").child("TenBenh").setValue("Mụn li ti ở mặt");

        myRef.child("62").child("DoLinhNghiem").setValue(0);
        myRef.child("62").child("GhiChu").setValue("-");
        myRef.child("62").child("SoBenh").setValue("20,00");
        myRef.child("62").child("TenBenh").setValue("Mụn thịt quanh mắt");

        myRef.child("63").child("DoLinhNghiem").setValue(0);
        myRef.child("63").child("GhiChu").setValue("-");
        myRef.child("63").child("SoBenh").setValue("260");
        myRef.child("63").child("TenBenh").setValue("Nghẹn và tức ngực khó thở");

        myRef.child("64").child("DoLinhNghiem").setValue(0);
        myRef.child("64").child("GhiChu").setValue("-");
        myRef.child("64").child("SoBenh").setValue("620");
        myRef.child("64").child("TenBenh").setValue("Nghẹn ở cổ");

        myRef.child("65").child("DoLinhNghiem").setValue(0);
        myRef.child("65").child("GhiChu").setValue("-");
        myRef.child("65").child("SoBenh").setValue("120060");
        myRef.child("65").child("TenBenh").setValue("Nghẹt mũi");

        myRef.child("66").child("DoLinhNghiem").setValue(0);
        myRef.child("66").child("GhiChu").setValue("-");
        myRef.child("66").child("SoBenh").setValue("26 | 260 | 2000600 | 720060 | 7200600");
        myRef.child("66").child("TenBenh").setValue("Ngủ ngáy");

        myRef.child("67").child("DoLinhNghiem").setValue(0);
        myRef.child("67").child("GhiChu").setValue("-");
        myRef.child("67").child("SoBenh").setValue("002 | 0002 | 00002");
        myRef.child("67").child("TenBenh").setValue("Ngứa bụng (bầu)");

        myRef.child("68").child("DoLinhNghiem").setValue(0);
        myRef.child("68").child("GhiChu").setValue("-");
        myRef.child("68").child("SoBenh").setValue("2060 | 260 | 20060 | 200600 | 260");
        myRef.child("68").child("TenBenh").setValue("Nhiệt miệng");

        myRef.child("69").child("DoLinhNghiem").setValue(0);
        myRef.child("69").child("GhiChu").setValue("-");
        myRef.child("69").child("SoBenh").setValue("64380 | 643820");
        myRef.child("69").child("TenBenh").setValue("Nôn mửa, tiêu chảy");

        myRef.child("70").child("DoLinhNghiem").setValue(0);
        myRef.child("70").child("GhiChu").setValue("-");
        myRef.child("70").child("SoBenh").setValue("8200");
        myRef.child("70").child("TenBenh").setValue("Nước ăn chân tay gây mụn ngứa khó chịu");

        myRef.child("71").child("DoLinhNghiem").setValue(0);
        myRef.child("71").child("GhiChu").setValue("-");
        myRef.child("71").child("SoBenh").setValue("260");
        myRef.child("71").child("TenBenh").setValue("Nấm lưỡi");

        myRef.child("72").child("DoLinhNghiem").setValue(0);
        myRef.child("72").child("GhiChu").setValue("-");
        myRef.child("72").child("SoBenh").setValue("2065");
        myRef.child("72").child("TenBenh").setValue("Nấm Móng Tay");

        myRef.child("73").child("DoLinhNghiem").setValue(0);
        myRef.child("73").child("GhiChu").setValue("-");
        myRef.child("73").child("SoBenh").setValue("206 | 2600 | 20600 | 200600");
        myRef.child("73").child("TenBenh").setValue("Nổi mụn");

        myRef.child("74").child("DoLinhNghiem").setValue(0);
        myRef.child("74").child("GhiChu").setValue("-");
        myRef.child("74").child("SoBenh").setValue("650");
        myRef.child("74").child("TenBenh").setValue("Nổi nhiều gân xanh (Chân, tay, ngực)");

        myRef.child("75").child("DoLinhNghiem").setValue(0);
        myRef.child("75").child("GhiChu").setValue("-");
        myRef.child("75").child("SoBenh").setValue("10000");
        myRef.child("75").child("TenBenh").setValue("Nứt xương sọ");

        myRef.child("76").child("DoLinhNghiem").setValue(0);
        myRef.child("76").child("GhiChu").setValue("-");
        myRef.child("76").child("SoBenh").setValue("10.00.06");
        myRef.child("76").child("TenBenh").setValue("Phình đại tràng");

        myRef.child("77").child("DoLinhNghiem").setValue(0);
        myRef.child("77").child("GhiChu").setValue("-");
        myRef.child("77").child("SoBenh").setValue("71000");
        myRef.child("77").child("TenBenh").setValue("Phù chân (bầu)");

        myRef.child("78").child("DoLinhNghiem").setValue(0);
        myRef.child("78").child("GhiChu").setValue("Nếu đọc mà khó chịu thì ngừng ngay");
        myRef.child("78").child("SoBenh").setValue("620 | 370 | 730");
        myRef.child("78").child("TenBenh").setValue("Phù thúng");

        myRef.child("79").child("DoLinhNghiem").setValue(0);
        myRef.child("79").child("GhiChu").setValue("-");
        myRef.child("79").child("SoBenh").setValue("3820 | 38200 | 382000");
        myRef.child("79").child("TenBenh").setValue("Phổi yếu (mùa đông gây ngứa ngáy)");

        myRef.child("80").child("DoLinhNghiem").setValue(0);
        myRef.child("80").child("GhiChu").setValue("-");
        myRef.child("80").child("SoBenh").setValue("260 | 206");
        myRef.child("80").child("TenBenh").setValue("Quai bị");

        myRef.child("81").child("DoLinhNghiem").setValue(0);
        myRef.child("81").child("GhiChu").setValue("-");
        myRef.child("81").child("SoBenh").setValue("380 | 43820");
        myRef.child("81").child("TenBenh").setValue("Ra mồ hồi tay chân");

        myRef.child("82").child("DoLinhNghiem").setValue(0);
        myRef.child("82").child("GhiChu").setValue("-");
        myRef.child("82").child("SoBenh").setValue("80.65");
        myRef.child("82").child("TenBenh").setValue("Ruột kích thích");

        myRef.child("83").child("DoLinhNghiem").setValue(0);
        myRef.child("83").child("GhiChu").setValue("-");
        myRef.child("83").child("SoBenh").setValue("26");
        myRef.child("83").child("TenBenh").setValue("Rát lưỡi, nứt lưỡi");

        myRef.child("84").child("DoLinhNghiem").setValue(0);
        myRef.child("84").child("GhiChu").setValue("-");
        myRef.child("84").child("SoBenh").setValue("1206 | 12060");
        myRef.child("84").child("TenBenh").setValue("Răng đau");

        myRef.child("85").child("DoLinhNghiem").setValue(0);
        myRef.child("85").child("GhiChu").setValue("-");
        myRef.child("85").child("SoBenh").setValue("820 | 650 | 260 | 1260 | 160");
        myRef.child("85").child("TenBenh").setValue("Rối loạn tiền đình");

        myRef.child("86").child("DoLinhNghiem").setValue(0);
        myRef.child("86").child("GhiChu").setValue("-");
        myRef.child("86").child("SoBenh").setValue("102060");
        myRef.child("86").child("TenBenh").setValue("Rụng tóc");

        myRef.child("87").child("DoLinhNghiem").setValue(0);
        myRef.child("87").child("GhiChu").setValue("-");
        myRef.child("87").child("SoBenh").setValue("820");
        myRef.child("87").child("TenBenh").setValue("Say tàu xe, say sóng");

        myRef.child("88").child("DoLinhNghiem").setValue(0);
        myRef.child("88").child("GhiChu").setValue("-");
        myRef.child("88").child("SoBenh").setValue("60430 | 6004300 | 600043000");
        myRef.child("88").child("TenBenh").setValue("Suy buồng trứng (mất kinh)");

        myRef.child("89").child("DoLinhNghiem").setValue(0);
        myRef.child("89").child("GhiChu").setValue("-");
        myRef.child("89").child("SoBenh").setValue("200060 hay 2000600");
        myRef.child("89").child("TenBenh").setValue("Suy thận, nói không ra hơi, mất khả năng hét, giọng yếu");

        myRef.child("90").child("DoLinhNghiem").setValue(0);
        myRef.child("90").child("GhiChu").setValue("-");
        myRef.child("90").child("SoBenh").setValue("20060.530");
        myRef.child("90").child("TenBenh").setValue("Suy tim");

        myRef.child("91").child("DoLinhNghiem").setValue(0);
        myRef.child("91").child("GhiChu").setValue("-");
        myRef.child("91").child("SoBenh").setValue("72,00,00.60,05");
        myRef.child("91").child("TenBenh").setValue("Sùi mào gà");

        myRef.child("92").child("DoLinhNghiem").setValue(0);
        myRef.child("92").child("GhiChu").setValue("-");
        myRef.child("92").child("SoBenh").setValue("Sắc quả sung khô thành nước uống");
        myRef.child("92").child("TenBenh").setValue("Sỏi mật");

        myRef.child("93").child("DoLinhNghiem").setValue(0);
        myRef.child("93").child("GhiChu").setValue("-");
        myRef.child("93").child("SoBenh").setValue("2006040 | 20060400 | 200600400");
        myRef.child("93").child("TenBenh").setValue("Sỏi niệu quản, sỏi thận");

        myRef.child("94").child("DoLinhNghiem").setValue(0);
        myRef.child("94").child("GhiChu").setValue("-");
        myRef.child("94").child("SoBenh").setValue("720.40.60");
        myRef.child("94").child("TenBenh").setValue("Sỏi thận");

        myRef.child("95").child("DoLinhNghiem").setValue(0);
        myRef.child("95").child("GhiChu").setValue("-");
        myRef.child("95").child("SoBenh").setValue("100.600");
        myRef.child("95").child("TenBenh").setValue("Số truyền năng lượng vui vẻ, tích cực");

        myRef.child("96").child("DoLinhNghiem").setValue(0);
        myRef.child("96").child("GhiChu").setValue("-");
        myRef.child("96").child("SoBenh").setValue("53.21");
        myRef.child("96").child("TenBenh").setValue("Số trị tiểu đường");

        myRef.child("97").child("DoLinhNghiem").setValue(0);
        myRef.child("97").child("GhiChu").setValue("-");
        myRef.child("97").child("SoBenh").setValue("6538.206 | 6538.2006");
        myRef.child("97").child("TenBenh").setValue("Sốt xuất huyết");

        myRef.child("98").child("DoLinhNghiem").setValue(0);
        myRef.child("98").child("GhiChu").setValue("-");
        myRef.child("98").child("SoBenh").setValue("1260 | 12060");
        myRef.child("98").child("TenBenh").setValue("Teo não");

        myRef.child("99").child("DoLinhNghiem").setValue(0);
        myRef.child("99").child("GhiChu").setValue("-");
        myRef.child("99").child("SoBenh").setValue("540");
        myRef.child("99").child("TenBenh").setValue("Teo đường mật bẩm sinh");

        myRef.child("100").child("DoLinhNghiem").setValue(0);
        myRef.child("100").child("GhiChu").setValue("Trì Chú Đại Bi 49-108 biến");
        myRef.child("100").child("SoBenh").setValue("Trì Chú Đại Bi 49-108 biến");
        myRef.child("100").child("TenBenh").setValue("Thiền bị ấn đường tối om");

        myRef.child("101").child("DoLinhNghiem").setValue(0);
        myRef.child("101").child("GhiChu").setValue("-");
        myRef.child("101").child("SoBenh").setValue("06.070.60 | 560");
        myRef.child("101").child("TenBenh").setValue("Thoái hóa khớp gối, đau khớp");

        myRef.child("102").child("DoLinhNghiem").setValue(0);
        myRef.child("102").child("GhiChu").setValue("Kết hợp lạy sám hối");
        myRef.child("102").child("SoBenh").setValue("72006");
        myRef.child("102").child("TenBenh").setValue("Thoái hóa đĩa đệm tê xuống chân");

        myRef.child("103").child("DoLinhNghiem").setValue(0);
        myRef.child("103").child("GhiChu").setValue("-");
        myRef.child("103").child("SoBenh").setValue("20650 | 206500");
        myRef.child("103").child("TenBenh").setValue("Thoái hóa đột sống cổ");

        myRef.child("104").child("DoLinhNghiem").setValue(0);
        myRef.child("104").child("GhiChu").setValue("-");
        myRef.child("104").child("SoBenh").setValue("72006 | 720060");
        myRef.child("104").child("TenBenh").setValue("Thoát vĩ đĩa đệm");

        myRef.child("105").child("DoLinhNghiem").setValue(0);
        myRef.child("105").child("GhiChu").setValue("-");
        myRef.child("105").child("SoBenh").setValue("265 | 2650 | 26500");
        myRef.child("105").child("TenBenh").setValue("Thâm môi");

        myRef.child("106").child("DoLinhNghiem").setValue(0);
        myRef.child("106").child("GhiChu").setValue("-");
        myRef.child("106").child("SoBenh").setValue("26,00,00");
        myRef.child("106").child("TenBenh").setValue("Thâm môi do nhiễm son chì");

        myRef.child("107").child("DoLinhNghiem").setValue(0);
        myRef.child("107").child("GhiChu").setValue("-");
        myRef.child("107").child("SoBenh").setValue("72.00.06");
        myRef.child("107").child("TenBenh").setValue("Thần kinh tọa đau từ mông xuống chân");

        myRef.child("108").child("DoLinhNghiem").setValue(0);
        myRef.child("108").child("GhiChu").setValue("-");
        myRef.child("108").child("SoBenh").setValue("820 | 280");
        myRef.child("108").child("TenBenh").setValue("Thủy đậu");

        myRef.child("109").child("DoLinhNghiem").setValue(0);
        myRef.child("109").child("GhiChu").setValue("-");
        myRef.child("109").child("SoBenh").setValue("71,00,00 | 72,00,00");
        myRef.child("109").child("TenBenh").setValue("Tinh trùng yếu");

        myRef.child("110").child("DoLinhNghiem").setValue(0);
        myRef.child("110").child("GhiChu").setValue("Hết thì dừng ngay");
        myRef.child("110").child("SoBenh").setValue("384");
        myRef.child("110").child("TenBenh").setValue("Tiêu chảy");

        myRef.child("111").child("DoLinhNghiem").setValue(0);
        myRef.child("111").child("GhiChu").setValue("-");
        myRef.child("111").child("SoBenh").setValue("26");
        myRef.child("111").child("TenBenh").setValue("Tiền mãn kinh, đổ mồ hôi lúc nóng lúc lạnh");

        myRef.child("112").child("DoLinhNghiem").setValue(0);
        myRef.child("112").child("GhiChu").setValue("-");
        myRef.child("112").child("SoBenh").setValue("2600 | 26000 | 600");
        myRef.child("112").child("TenBenh").setValue("Tiểu buốt");

        myRef.child("113").child("DoLinhNghiem").setValue(0);
        myRef.child("113").child("GhiChu").setValue("-");
        myRef.child("113").child("SoBenh").setValue("2000.6000");
        myRef.child("113").child("TenBenh").setValue("Tiểu khó, tiểu không hết");

        myRef.child("114").child("DoLinhNghiem").setValue(0);
        myRef.child("114").child("GhiChu").setValue("-");
        myRef.child("114").child("SoBenh").setValue("8100 | 81000");
        myRef.child("114").child("TenBenh").setValue("Tiểu nhiều lần trong đêm");

        myRef.child("115").child("DoLinhNghiem").setValue(0);
        myRef.child("115").child("GhiChu").setValue("-");
        myRef.child("115").child("SoBenh").setValue("1206");
        myRef.child("115").child("TenBenh").setValue("TIỂU NHIỀU, NHIỀU LẦN, TIỂU ĐÊM");

        myRef.child("116").child("DoLinhNghiem").setValue(0);
        myRef.child("116").child("GhiChu").setValue("-");
        myRef.child("116").child("SoBenh").setValue("206");
        myRef.child("116").child("TenBenh").setValue("Tiểu đường (đang lên muốn giảm)");

        myRef.child("117").child("DoLinhNghiem").setValue(0);
        myRef.child("117").child("GhiChu").setValue("Lạy sám hối 3-6 tháng");
        myRef.child("117").child("SoBenh").setValue("Lạy sám hối 3-6 tháng");
        myRef.child("117").child("TenBenh").setValue("Tràn dịch khớp gối");

        myRef.child("118").child("DoLinhNghiem").setValue(0);
        myRef.child("118").child("GhiChu").setValue("-");
        myRef.child("118").child("SoBenh").setValue("71000 | 710000 | 8100");
        myRef.child("118").child("TenBenh").setValue("Trĩ ngoại");

        myRef.child("119").child("DoLinhNghiem").setValue(0);
        myRef.child("119").child("GhiChu").setValue("-");
        myRef.child("119").child("SoBenh").setValue("8260 | 82600 | 820600");
        myRef.child("119").child("TenBenh").setValue("Trĩ nội");

        myRef.child("120").child("DoLinhNghiem").setValue(0);
        myRef.child("120").child("GhiChu").setValue("Lạy xám hối");
        myRef.child("120").child("SoBenh").setValue("Lạy xám hối");
        myRef.child("120").child("TenBenh").setValue("Trầm cảm");

        myRef.child("121").child("DoLinhNghiem").setValue(0);
        myRef.child("121").child("GhiChu").setValue("-");
        myRef.child("121").child("SoBenh").setValue("200.600");
        myRef.child("121").child("TenBenh").setValue("Trắng da");

        myRef.child("122").child("DoLinhNghiem").setValue(0);
        myRef.child("122").child("GhiChu").setValue("-");
        myRef.child("122").child("SoBenh").setValue("120060");
        myRef.child("122").child("TenBenh").setValue("Trị nẻ gót chân");

        myRef.child("123").child("DoLinhNghiem").setValue(0);
        myRef.child("123").child("GhiChu").setValue("-");
        myRef.child("123").child("SoBenh").setValue("20600");
        myRef.child("123").child("TenBenh").setValue("Amidan");

        myRef.child("124").child("DoLinhNghiem").setValue(0);
        myRef.child("124").child("GhiChu").setValue("-");
        myRef.child("124").child("SoBenh").setValue("650.30 | 260 | 2600 | 3800");
        myRef.child("124").child("TenBenh").setValue("Trị Rối Loạn Hệ Thần Kinh Thực Vật");

        myRef.child("125").child("DoLinhNghiem").setValue(0);
        myRef.child("125").child("GhiChu").setValue("-");
        myRef.child("125").child("SoBenh").setValue("120060");
        myRef.child("125").child("TenBenh").setValue("Táo bón hay đầy hơi");

        myRef.child("126").child("DoLinhNghiem").setValue(0);
        myRef.child("126").child("GhiChu").setValue("-");
        myRef.child("126").child("SoBenh").setValue("71000 | 100060");
        myRef.child("126").child("TenBenh").setValue("Amidan");

        myRef.child("127").child("DoLinhNghiem").setValue(0);
        myRef.child("127").child("GhiChu").setValue("-");
        myRef.child("127").child("SoBenh").setValue("2065");
        myRef.child("127").child("TenBenh").setValue("Tê chân");

        myRef.child("128").child("DoLinhNghiem").setValue(0);
        myRef.child("128").child("GhiChu").setValue("-");
        myRef.child("128").child("SoBenh").setValue("80.2065");
        myRef.child("128").child("TenBenh").setValue("Tê tay cho hội chứng cổ tay");

        myRef.child("129").child("DoLinhNghiem").setValue(0);
        myRef.child("129").child("GhiChu").setValue("Có thể thay đổi 1 2; số 4 5");
        myRef.child("129").child("SoBenh").setValue("1600430 | 16000430");
        myRef.child("129").child("TenBenh").setValue("Tóc bạc sớm");

        myRef.child("130").child("DoLinhNghiem").setValue(0);
        myRef.child("130").child("GhiChu").setValue("-");
        myRef.child("130").child("SoBenh").setValue("2640 | 2650");
        myRef.child("130").child("TenBenh").setValue("Tóc bạc sớm do thận yếu, thuỷ vượng hoả yếu");

        myRef.child("131").child("DoLinhNghiem").setValue(0);
        myRef.child("131").child("GhiChu").setValue("-");
        myRef.child("131").child("SoBenh").setValue("1006 | 10006");
        myRef.child("131").child("TenBenh").setValue("Tăng chiều cao");

        myRef.child("132").child("DoLinhNghiem").setValue(0);
        myRef.child("132").child("GhiChu").setValue("-");
        myRef.child("132").child("SoBenh").setValue("2000.60 | 2000.600 | 8000.40.60 | 38000.40.60 | 640.000.720");
        myRef.child("132").child("TenBenh").setValue("Tăng sữa mẹ");

        myRef.child("133").child("DoLinhNghiem").setValue(0);
        myRef.child("133").child("GhiChu").setValue("-");
        myRef.child("133").child("SoBenh").setValue("26 | 206 | 260");
        myRef.child("133").child("TenBenh").setValue("Tắc mũi");

        myRef.child("134").child("DoLinhNghiem").setValue(0);
        myRef.child("134").child("GhiChu").setValue("-");
        myRef.child("134").child("SoBenh").setValue("260 | 20600, nếu bị đoản hơi thì 620");
        myRef.child("134").child("TenBenh").setValue("Tắc nghẽn phổi mãn tính");

        myRef.child("135").child("DoLinhNghiem").setValue(0);
        myRef.child("135").child("GhiChu").setValue("Kiên trì day hốc mắt sẽ khỏi");
        myRef.child("135").child("SoBenh").setValue("Kiên trì day hốc mắt sẽ khỏi");
        myRef.child("135").child("TenBenh").setValue("Tắc tuyến lệ mắt");

        myRef.child("136").child("DoLinhNghiem").setValue(0);
        myRef.child("136").child("GhiChu").setValue("-");
        myRef.child("136").child("SoBenh").setValue("3810");
        myRef.child("136").child("TenBenh").setValue("Tức ngực , khó chịu phần ngực");

        myRef.child("137").child("DoLinhNghiem").setValue(0);
        myRef.child("137").child("GhiChu").setValue("Lạy sám hối và niệm số");
        myRef.child("137").child("SoBenh").setValue("2605");
        myRef.child("137").child("TenBenh").setValue("U hoạt dịch ở tay (u lành)");

        myRef.child("138").child("DoLinhNghiem").setValue(0);
        myRef.child("138").child("GhiChu").setValue("Một dạng u máu");
        myRef.child("138").child("SoBenh").setValue("6000");
        myRef.child("138").child("TenBenh").setValue("U lạc nội mạc tử cung");

        myRef.child("139").child("DoLinhNghiem").setValue(0);
        myRef.child("139").child("GhiChu").setValue("-");
        myRef.child("139").child("SoBenh").setValue("200600");
        myRef.child("139").child("TenBenh").setValue("U máu ở gan");

        myRef.child("140").child("DoLinhNghiem").setValue(0);
        myRef.child("140").child("GhiChu").setValue("-");
        myRef.child("140").child("SoBenh").setValue("6000 | 20.6000");
        myRef.child("140").child("TenBenh").setValue("U nang buồng trứng cả 2 bên");

        myRef.child("141").child("DoLinhNghiem").setValue(0);
        myRef.child("141").child("GhiChu").setValue("-");
        myRef.child("141").child("SoBenh").setValue("6000 | 26000 | 20600 | 10,00,60");
        myRef.child("141").child("TenBenh").setValue("U xơ tử cung");

        myRef.child("142").child("DoLinhNghiem").setValue(0);
        myRef.child("142").child("GhiChu").setValue("A. CÁCH TU TẬP VỚI NHỮNG NGƯỜI BỆNH UNG THƯ, BỆNH HIẾM GẶP CHƯA TÌM RA THUỐC CHỮA - THẦY HOÀNG QUÝ SƠN \n" +
                "\n" +
                "Ai bị bệnh thì đó là theo số mạng, tức là nhân quả nghiệp báo của mỗi người. Nhưng với những người bệnh nặng chưa tìm được thầy thuốc hoặc những bệnh ung thư, bệnh hiếm gặp thì còn nước còn tát!\n" +
                "Chuyện này xin hỏi quý vị mấy điều:\n" +
                "Hiện tại bệnh nhân còn biết gì nữa không? Bệnh nhân còn muốn sống nữa không và muốn sống vì lý do gì?\n" +
                "Bệnh nhân phải xác định rõ ràng cụ thể mới mong giúp được gì hay không?\n" +
                "• Với Phật Pháp thì cần ba yếu tố: \n" +
                "+ Nhất Quyết Tin\n" +
                "+ Nhất Quyết Làm \n" +
                "+ Nhất Quyết Được\n" +
                "• Và Quý vị phải thật sự hiểu rõ vấn đề:\n" +
                "\n" +
                "Có bệnh thì phải đi Bác sĩ. Nếu như Bác sĩ không tìm ra phương án và chữa mãi không khỏi thì đó là Bệnh Nghiệp. Đã là bệnh Nghiệp thì chỉ có Phật Pháp mới cứu được. \n" +
                "\n" +
                "Nếu bạn muốn tự cứu mình, cứu người thì nhất quyết tin và Tu hoặc là bày cho họ cách Tu, chỉ có vậy sau đó cuộc đời mới sướng được. Còn không nếu bạn muốn cứu người chỉ tạo thêm sự đau khổ cho họ mà thôi.\n" +
                "\n" +
                "• Khi tu tập cần tu với Tâm Chí Thành tin tưởng giao hết tính mạng mình cho Chư Phật, Chư Bồ Tát và không có lo lắng gì cả, gạt vấn đề bạn đang gặp phải sang một bên. Còn nếu các bạn tự muốn lo thì các Ngài sẽ để cho các bạn lo. Chỉ có vậy thôi.\n" +
                "\n" +
                "Tội từ tâm khởi đem tâm sám \n" +
                "Tâm được tịnh rồi tội liền tiêu \n" +
                "Tội tiêu tâm tịnh thảy đều không \n" +
                "Ấy mới thật là chân sám hối!\n" +
                "\n" +
                "Nhận thấy lỗi để sửa là rất tốt. Nhận thấy lỗi để đau khổ thì lại là bệnh nặng hơn. Không nhận ra lỗi thì là Ngu si, nhận ra lỗi để đau khổ là Đại Ngu si.\n" +
                "\n" +
                "Người mà lỗi mình còn không thể tha thứ được thì lỗi người khó mà bỏ qua. Bám chấp là gốc của Vô Minh, thế thì bám chấp nào mà không gây ra đau khổ, cho dù đó là bám chấp để giải thoát.\n" +
                "\n" +
                "Vì sao? Giải thoát tức là thoát khỏi ràng buộc, thế mà lại tự cột buộc ràng rịt mình và bám chấp vào giải thoát cũng là đang cố tình làm cho mình đau kh ổ mà thôi. Hãy tập tha thứ cho mình, tha thứ cho người. Tâm không tịnh thì tội nào tiêu được!!!\n" +
                "\n" +
                "<3 HƯỚNG DẪN CÁCH HÀNH TRÌ - THẦY HOÀNG QUÝ SƠN \n" +
                "\n" +
                "Đối với những người mắc bệnh ung thư, những bệnh hiếm gặp chưa tìm ra thuốc điều trị thì về cơ bản sáng, trưa, tối và trước khi đi ngủ sẽ là như vầy, Ai mà còn đi làm thì bố trí sắp xếp thời gian sao cho hợp lý với mình nhất:\n" +
                "\n" +
                "1. BUỔI SÁNG\n" +
                "Nếu như quý vị không còn làm gì thì sáng Lạy Sám Hối và phải ráng lạy theo như video. Nếu không còn sức lạy như video thì quỳ lạy, không quỳ lạy được thì ngồi lạy, không thể ngồi được phải nằm 1 chỗ thì nằm lạy.\n" + "Hoặc vào youtube gõ tìm: “Lạy Sám Hối - Hoàng Quý Sơn” sẽ cho ra kết quả. Còn phần chữ thì có trong mục 2.4.1+\n" + "2. BUỔI TRƯA\n" +
                "\n" +
                "Trưa thì trì Chú Dược Sư 108 lần và dùng Ấn Cát Tường chỉ vào nước uống. Còn lại bất kỳ thời gian nào khác thì cứ mua xâu chuỗi 18 hạt rồi niệm Nam Mô Dược Sư Phật, 1 lần thì lần 1 hạt. Cứ thế mà lần chuỗi và nhớ số mỗi lần hết 18 hạt thì đếm 1. Xong hết 60 xâu chuỗi thì có thể đọc 60 chuỗi khác. Quan trọng là phải nhớ số chuỗi đã lần để cột tâm và không suy nghĩ lo sợ!\n" +
                "\n" +
                "CHÚ DƯỢC SƯ:\n" +
                "Nam mô Bạc già phạt đế, bệ sát xã, Lũ lô thích lưu ly, bác lặc bà, hắc ra xà dã. Đát tha yết đa tha, a ra hắc đế. Tam miệu tam bột đà da, đát điệt tha. Án! bệ sát thệ, bệ sát thệ, bệ sát xã, tam một yết đế toá ha. (108 lần từ nam mô đến toá ha)\n" +
                "Nếu sau đó 1-3 năm vẫn luôn trì Chú Dược Sư và niệm Dược Sư như đã nói mỗi ngày thì chắc là sống được như ý.\n" +
                "\n" +
                "3. BUỔI TỐI\n" +
                "\n" +
                "Tối thì Sám Oan Gia theo hướng dẫn trong bài CÁCH GIẢI TRỪ OÁN THÙ CỦA OAN GIA TRÁI CHỦ\n" +
                "\n" +
                "*Phỏng theo cách Ngài Trịnh Hạ Tường\n" +
                "\n" +
                "1. Đầu Tiên Khuyên Dạy Cách Giải Trừ Oán Thù.\n" +
                "\n" +
                "Kính thưa Quý vị oan gia trái chủ trên thân tôi. Từ vô lượng kiếp đến này, vì do ngu si vô trí, tôi đã vô tình hay cố ý làm tổn hại quý vị. Nay tôi được thân người có duyên với Phật Pháp nên muốn cùng quý vị tu tập và mong quý vị hoan hỉ tha thứ bỏ qua cho. Nếu như quý vị nhất định trả thù bằng mọi giá, thì tôi xin nhận chịu quả báo, không dám than van, oan trách gì vì nhân này do tôi gây ra. \n" +
                "\n" +
                "Tuy nhiên, nếu quý vị có trả thù thì chỉ được thoả mãn nhất thời, mà vẫn không giải quyết được vấn đề căn bản vì vẫn phải luân hồi trong lục đạo, đối với chúng ta đều không có lợi ích gì cả. Cách này chỉ tổn người hại mình, nên mong chúng ta hãy cùng nhau niệm Phật để cùng nhau vượt thoát sinh tử luân hồi.\n" +
                "\n" +
                "Từ nay nếu được thiện lành nào, thì xin hồi hướng cho quý vị sớm được siêu thoát, mong quý vị hay tha thứ cho tôi và không làm chướng ngại để chúng ta cùng nhau tu tập.\n" +
                "Tôi mong quý vị thâu lại THÂN TÂM cùng tôi niệm Thánh Hiệu Dược Sư Phật, một niệm tương ứng hoành siêu tam giới, siêu thoát tam giới tức được đắc đạo, chỉ cần tinh tấn tu hành sẽ được thành\n" +
                "Phật. Chỉ cần thâu lại thân tâm niệm Thánh hiệu Dược Sư Phật, một niệm tương ứng phước thọ tăng trưởng, tiêu tai diệt chướng, chỉ cần thâu lại thân tâm niệm Thánh hiệu Dược Sư Phật, một niệm tương ứng, tu gì được nấy.\n" +
                "\n" +
                "Nhưng chúng tôi hy vọng quý vị đừng tu nhân thiên quả báo, cố gắng tu tập, phát tâm Bồ Đề, nhất tâm chuyên niệm Dược Sư Phật thánh hiệu, chỉ cần tu hành đúng pháp, tất nhiên đắc đạo tu hành chánh quả.\n" +
                "\n" +
                "2. Quy Y Tam Bảo Cho Oan Gia Trái Chủ\n" +
                "\n" +
                "Tôi tên (........), oan gia trái chủ trên thân tôi (tức\n" +
                "nghiệp lự c) quý vị hãy nghe rõ, quý vị không nghe Tam Bảo không hiểu Quy Y, cho nên thọ khổ luân hồi. Nay tôi truyền thọ Quy Y Tam Bảo, quý vị phải lắng nghe, tôi niệm một lần, quý vị hãy theo tôi niệm một lần.\n" +
                "\n" +
                "Quy Y Phật, Quy Y Pháp, Quy Y Tăng\n" +
                "Quy Y Phật, Lưỡng Túc Tôn\n" +
                "Quy Y Pháp, Ly Dục Tôn\n" +
                "Quy Y Tăng, Chúng Trung Tôn\n" +
                "Quy Y Phật, Không Đọa Địa Ngục\n" +
                "Quy Y Pháp, Không Đọa Ngạ Quỷ\n" +
                "Quy Y Tăng, Không Đọa Súc Sanh\n" +
                "\n" +
                "(niệm 3 lần từ quy y Phật ====>>> súc sanh)\n" +
                "\n" +
                "Lễ Quy Y viên mãn, bây giờ tôi vì quý vị niệm Thánh hiệu Dược Sư Phật 2.000 lần. \n" +
                "\n" +
                "Xin mời quý vị thâu lại thân tâm cùng tôi chuyên tâm trì niệm Thánh hiệu NAM MÔ DƯỢC SƯ PHẬT (2000 lần)\n" +
                "\n" +
                "Niệm Xong Thánh Hiệu, Vì Oan Gia Trái Chủ, Tụng Bát Nhã Tâm Kinh (1 Lần).\n" +
                "\n" +
                "BÁT NHÃ BA LA MẬT ĐA TÂM KINH\n" +
                "\n" +
                "Quán tự tại Bồ Tát, hành thâm Bát Nhã Ba La Mật, TỨC DIỆU PHÁP TRÍ ĐỘ, bỗng soi thấy ngũ uẩn đều không có tự tánh, thực chứng điều ấy xong ngài vướt thoát tất cả mọi khổ đau ách nạn.\n" +
                "Nghe đây Xá Lợi Tử, sắc chẳng khác gì không, không chẳng khác gì sắc, sắc đích thực là không, không đích thực là sắc, còn lại bốn uẩn kia cũng đều như vậy cả.\n" +
                "Xá Lợi Tử nghe đây! Thể mọi pháp đều không, không sanh cũng không diệt, không dơ cũng không sạch, không thêm cũng không bớt, cho nên trong Tánh Không không có sắc thọ tưởng, cũng không có hành thức, không có nhãn nhĩ tỉ thiệt thân ý sáu căn, không có sắc thanh hương vị xúc pháp sáu trần, không có mười tám giới, từ nhãn đến ý thức, không hề có vô minh, không có hết vô minh, cho đến không lão tử, cũng không hết lão tử, không khổ tập diệt đạo, không trí cũng không đắc vì không có sở đắc.\n" +
                "\n" +
                "Khi một vị Bồ tát nương DIỆU PHÁP TRÍ ĐỘ Bát Nhã Ba La Mật thì tâm không chướng ngại, vì tâm không chướng ngại, nên không có sợ hãi, xa lìa mọi mộng tưởng, xa lìa mọi điên đảo, đạt Niết Bàn tuyệt đối. Chư Phật trong ba đời y Bát Nhã Ba La Mật, nên đắc vô thượng giác.\n" +
                "\n" +
                "Vậy nên phải biết rằng Bát Nhã Ba La Mật là linh chú đại thần, là linh chí đại minh, là linh chú vô thượng, là linh chú tuyệt đỉnh, là chân lý bất vọng, có năng lực tiêu trừ tất cả mọi khổ nạn, cho nên tôi muốn thuyết câu thần chú trí đ ộ, Bát Nhã Ba La Mật. Nói xong Đức Bồ Tát liền niệm thần chú rằng:\n" +
                "\n" +
                "Ga tê Ga tê, Pa ra Ga tê, Pa ra sam ga tê, Bô đi xóa ha (3 lần)\n" +
                "\n" +
                "Tụng Xong Tâm Kinh, vì oan gia trái chủ, tụng Chú Vãng Sanh (21 lần).\n" +
                "\n" +
                "CHÚ VÃNG SANH\n" +
                "\n" +
                "Nam mô a di đa bà dạ\n" +
                "Đa tha dà đa dạ\n" +
                "Đa địa dạ tha\n" +
                "A di rị đô bà tỳ\n" +
                "A di rị đa, tất đam bà tỳ\n" +
                "A di rị đa tì ca lan đế\n" +
                "A di rị đa tì ca lan đa\n" +
                "Dà di nị dà dà na\n" +
                "Chỉ đa ca lệ ta bà ha. \n" +
                "(21 lần từ Nam mô ====>>> bà ha)\n" +
                "\n" +
                "HỒI HƯỚNG\n" +
                "\n" +
                "Nguyện đem công đức này\n" +
                "Trang nghiêm Phật Tịnh Độ\n" +
                "Trên đền bốn ơn nặng\n" +
                "Dưới cứu khổ tam đồ\n" +
                "Nếu có ai thấy nghe\n" +
                "Đều phát tâm Bồ Đề\n" +
                "Hết một báo thân này\n" +
                "Đồng sanh cõi Cực Lạc\n" +
                "\n" +
                "5. Lời Kết Thúc\n" +
                "\n" +
                "Tất cả oan gia trái chủ trên thân tôi, lúc nãy tôi vừa quy y Tam Bảo cho quý vị, tụng niệm Phật hiệu Dược Sư Phật hai ngàn tiếng, tụng Tâm Kinh một lần, tụng chú vãng sanh 21 lần. Những pháp ngữ này đều tặng cho quý vị, hy vọng quý vị đừng làm chướng ngại cho tôi, mau rời khỏi thân tôi, tìm một chỗ tốt lành mà tu hành, phá mê khai ngộ, minh tâm kiến tánh, lìa khổ được vui, vãng sanh Đông Phương Thế Giới Tịnh Lưu Ly.\n" +
                "Nam Mô Dược Sư Phật (ba lần)\n" +
                "\n" +
                "2.5.4. TRƯỚC KHI LÊN GIƯỜNG ĐI NGỦ\n" +
                "\n" +
                "Mỗi tối trước khi ngủ và sáng khi vừa mới thức dậy nhớ nói chuyện tâm thức với các oan gia trái chủ và bệnh tật, dùng tay xoa xoa lên chỗ bệnh vỗ về và tâm sự với lòng chí thành và chân thật nhất:\n" +
                "\n" +
                "(Đây chính là một cách tôi hành trì mỗi ngày và đã chỉ bày cho một bạn trong Làng Ta, bạn ấy bị một căn bệnh hiếm gặp. Những ai có bệnh tật tại vị trí nào trên cơ thể, hoặc ung thư có thể đọc, tùy duyên mà hành trì xem có chút lợi lạc nào chăng)\n" +
                "\n" +
                "\"Nguyện cho thế giới được sớm hòa bình, tất cả chúng sinh đều được an lạc, không có loài nào vô tình hay cố ý não hại hay sát hại loài nào. Tất cả đều sống trong sự hòa hợp, an vui, hạnh phúc, giúp đ ỡ, đùm bọc lẫn nhau. Nếu từ vô lượng kiếp đến nay, tôi đã vô tình hay cố ý não hại hoặc sát hại bất cứ loài nào thì xin quý vị hoan hỉ tha thứ, bỏ qua cho và hãy cùng tôi tu hành tinh tấn cho đến khi giải thoát.\n" +
                "\n" +
                "Nguyện cho các oan gia trái chủ, các bệnh tật và các loại trùng cùng các chúng sinh đang s ống trên người của tôi hãy cùng tôi kết thành thiện tri thức, đời đời kiếp kiếp giáo hóa, giúp đỡ nhau tu học cho đến khi thành Phật Đạo!!!”\n" +
                "(đọc 3 lần hoặc đọc càng nhiều càng tốt, cứ thế lập đi lập lại cho đến khi ngủ thì thôi)\n" +
                "\n" +
                "Chú ý: Có thể thắt chỉ ngũ sắc 12 đại tướng Dược Xoa, cầu bệnh tật tiêu trừ để thêm hiệu quả.\n" +
                "Thầy Hoàng Quý Sơn\n" +
                "=======================\n" +
                "B. THAM KHẢO NÓI CHUYỆN TÂM THỨC VỚI BỆNH TẬT \n" +
                "\n" +
                "Đây chính là một cách mà chú Sơn đã chỉ bầy cho một bạn trong Làng Ta bạn bị một căn bệnh hiếm gặp. Những ai có bệnh tật tại vị trí nào trên cơ thể, hoặc ung thư có thể đọc mà tùy duyên mà hành trì xem có chút lợi lạc nào chăng. \n" +
                "\n" +
                "Thầy Hoàng Quý Sơn:\n" +
                "\n" +
                "1. Bạn hãy hành trì theo cách trì Chú Dược Sư và thắt chỉ ngũ sắc 12 đại tướng Dược Xoa, cầu bệnh tật tiêu trừ\n" +
                "\n" +
                "2. Nên niệm Dược Sư Phật liên tục bất kể đi đứng nằm ngồi khi có thời gian.\n" +
                "\n" +
                "3. Mỗi sáng tối trước khi thức và trước khi ngủ đều nói như vầy và dùng tay xoa xoa lên chỗ bệnh vỗ về và tâm sự với lòng chí thành và chân thật nhất:\n" +
                "\n" +
                "Nguyện cầu cho thế giới sớm hòa bình, tất cả chúng sinh đồng an lạc. Không có loài nào vô tình hay cố ý não hại hay sát hại bất cứ loài nào. Tất cả đều sống trong sự hòa hợp an vui hạnh phúc giúp đỡ đùm bọc lẫn nhau. Nếu như đời trước tôi đã ngu su si vô trí dù vô tình hay cố ý ý đã làm cho quý vị đau khổ, nên nay tôi phải bị chứng bệnh trên mặt này.\n" +
                "\n" +
                "Dù các vị trả thù cho hả giận tôi không dám than van oán trách, nhưng cũng chỉ hả giận nhất thời, nếu như quý vị hoan hỉ bỏ qua. Tôi sẽ phát tâm ngày đêm tu trì niệm Phật để cầu nguyện cho các vị sớm hết đau khổ hoặc được vãng sinh và nguyện đời đời chúng ta sẽ làm thiện tri thức giúp đỡ nhau tu học cho đến khi thành Phật đạo. \n" +
                "(cứ thế lập đi lập lại cho đến khi ngủ thì thôi)");
        myRef.child("142").child("SoBenh").setValue("-");
        myRef.child("142").child("TenBenh").setValue("Ung thư");

        myRef.child("143").child("DoLinhNghiem").setValue(0);
        myRef.child("143").child("GhiChu").setValue("-");
        myRef.child("143").child("SoBenh").setValue("120600");
        myRef.child("143").child("TenBenh").setValue("Ung thư - U nguyên bào thần kinh có 1 khối u ổ bụng và 1 khối u trên đầu");

        myRef.child("144").child("DoLinhNghiem").setValue(0);
        myRef.child("144").child("GhiChu").setValue("Đọc số kèm danh hiệu: Nam Mô Dược Sư Phật");
        myRef.child("144").child("SoBenh").setValue("60050000");
        myRef.child("144").child("TenBenh").setValue("Ung thư gan");

        myRef.child("145").child("DoLinhNghiem").setValue(0);
        myRef.child("145").child("GhiChu").setValue("-");
        myRef.child("145").child("SoBenh").setValue("640.20");
        myRef.child("145").child("TenBenh").setValue("Ung thư vú");

        myRef.child("146").child("DoLinhNghiem").setValue(0);
        myRef.child("146").child("GhiChu").setValue("-");
        myRef.child("146").child("SoBenh").setValue("720060 | 7200600");
        myRef.child("146").child("TenBenh").setValue("Viêm cột sống dính khớp");

        myRef.child("147").child("DoLinhNghiem").setValue(0);
        myRef.child("147").child("GhiChu").setValue("-");
        myRef.child("147").child("SoBenh").setValue("26 | 260 | 2600");
        myRef.child("147").child("TenBenh").setValue("Viêm da cơ địa");

        myRef.child("148").child("DoLinhNghiem").setValue(0);
        myRef.child("148").child("GhiChu").setValue("-");
        myRef.child("148").child("SoBenh").setValue("200600 | 650.30.820");
        myRef.child("148").child("TenBenh").setValue("Viêm gan B");

        myRef.child("149").child("DoLinhNghiem").setValue(0);
        myRef.child("149").child("GhiChu").setValue("-");
        myRef.child("149").child("SoBenh").setValue("20600");
        myRef.child("149").child("TenBenh").setValue("Viêm gan C");

        myRef.child("150").child("DoLinhNghiem").setValue(0);
        myRef.child("150").child("GhiChu").setValue("Đọc đến khi nào hết bệnh thì thôi.");
        myRef.child("150").child("SoBenh").setValue("650.30.820");
        myRef.child("150").child("TenBenh").setValue("Viêm gan, cao huyết áp, xơ cứng động mạch, bệnh tim, (đau đầu ù tai, viêm dạ dày, viêm khớp, âm hư dương cao, cần tư thuỷ hàm mộc, bổ gan ích thận, kiện tỳ hoà vị…)");

        myRef.child("151").child("DoLinhNghiem").setValue(0);
        myRef.child("151").child("GhiChu").setValue("-");
        myRef.child("151").child("SoBenh").setValue("80.2065 | 80.20650");
        myRef.child("151").child("TenBenh").setValue("Viêm gân");

        myRef.child("152").child("DoLinhNghiem").setValue(0);
        myRef.child("152").child("GhiChu").setValue("-");
        myRef.child("152").child("SoBenh").setValue("2600");
        myRef.child("152").child("TenBenh").setValue("Viêm họng mãn tính");

        myRef.child("153").child("DoLinhNghiem").setValue(0);
        myRef.child("153").child("GhiChu").setValue("-");
        myRef.child("153").child("SoBenh").setValue("120060");
        myRef.child("153").child("TenBenh").setValue("Viêm họng, viêm abidan, cảm cúng, nghẹt mũi, cảm sốt hoặc đầy hơi hay ăn thấy bị trào ngược");

        myRef.child("154").child("DoLinhNghiem").setValue(0);
        myRef.child("154").child("GhiChu").setValue("-");
        myRef.child("154").child("SoBenh").setValue("200.600");
        myRef.child("154").child("TenBenh").setValue("Viêm lỗ chân lông");

        myRef.child("155").child("DoLinhNghiem").setValue(0);
        myRef.child("155").child("GhiChu").setValue("-");
        myRef.child("155").child("SoBenh").setValue("6000");
        myRef.child("155").child("TenBenh").setValue("Viêm lộ tuyến độ 2 và viêm Amidan mãn tính");

        myRef.child("156").child("DoLinhNghiem").setValue(0);
        myRef.child("156").child("GhiChu").setValue("Nếu như xương răng không có ảnh hưởng gì thì có thể bỏ số 1 ra đọc: 260 | 2600 | 206000");
        myRef.child("156").child("SoBenh").setValue("1260 | 12600 | 1206000");
        myRef.child("156").child("TenBenh").setValue("Viêm lợi mãn tính");

        myRef.child("157").child("DoLinhNghiem").setValue(0);
        myRef.child("157").child("GhiChu").setValue("-");
        myRef.child("157").child("SoBenh").setValue("260 | 20600 | 206000");
        myRef.child("157").child("TenBenh").setValue("Viêm nhiễm nấm phụ khoa (Yeast Vagina Injection)");

        myRef.child("158").child("DoLinhNghiem").setValue(0);
        myRef.child("158").child("GhiChu").setValue("-");
        myRef.child("158").child("SoBenh").setValue("600.200.800 | 60.20.800");
        myRef.child("158").child("TenBenh").setValue("Viêm tuyến tụy");

        myRef.child("159").child("DoLinhNghiem").setValue(0);
        myRef.child("159").child("GhiChu").setValue("720060 hoặc 712060");
        myRef.child("159").child("SoBenh").setValue("1. Mỗi ngày sám hối oan gia 1 lần\n" +
                "2. Trì Chú Đại Bi 49-109 lần mỗi ngày hoặc niệm suốt ngày đêm bất kể đi tiểu gì cũng: \"Nam mô tầm thinh cứu khổ cứu nạn quảng đại linh cảm Quán Âm Bố Tát. Xin Ngài cứu con.\"\n" +
                "3.Bạn có thể đọc số 720060 hoặc 712060 + Nam mô Dược Sư Phật ngày 1-2 giờ. Lúc rãnh rỗi càng hành trì nhiều hơn và hồi hướng cho tất cả bệnh nhân ở khắp mọi nơi! Có thể nói chuyện tam thức oan gia trái chủ của mình và luôn để tâm an thì bệnh lập tức sẽ lành");
        myRef.child("159").child("TenBenh").setValue("Viêm tuỷ sống");

        myRef.child("160").child("DoLinhNghiem").setValue(0);
        myRef.child("160").child("GhiChu").setValue("-");
        myRef.child("160").child("SoBenh").setValue("2062060 | 20600 | 206200");
        myRef.child("160").child("TenBenh").setValue("Viêm xoang");

        myRef.child("161").child("DoLinhNghiem").setValue(0);
        myRef.child("161").child("GhiChu").setValue("-");
        myRef.child("161").child("SoBenh").setValue("1206");
        myRef.child("161").child("TenBenh").setValue("Vượng phổi");

        myRef.child("162").child("DoLinhNghiem").setValue(0);
        myRef.child("162").child("GhiChu").setValue("-");
        myRef.child("162").child("SoBenh").setValue("2604 | 2064");
        myRef.child("162").child("TenBenh").setValue("Vết thương bàn chân (phần mềm)");

        myRef.child("163").child("DoLinhNghiem").setValue(0);
        myRef.child("163").child("GhiChu").setValue("-");
        myRef.child("163").child("SoBenh").setValue("600500");
        myRef.child("163").child("TenBenh").setValue("Xơ gan");

        myRef.child("164").child("DoLinhNghiem").setValue(0);
        myRef.child("164").child("GhiChu").setValue("-");
        myRef.child("164").child("SoBenh").setValue("81260");
        myRef.child("164").child("TenBenh").setValue("Xương thịt lỏng lẻo, không săn chắc sau giảm cân");

        myRef.child("165").child("DoLinhNghiem").setValue(0);
        myRef.child("165").child("GhiChu").setValue("-");
        myRef.child("165").child("SoBenh").setValue("00260 | 002601 | 002600");
        myRef.child("165").child("TenBenh").setValue("Zona thần kinh");

        myRef.child("166").child("DoLinhNghiem").setValue(0);
        myRef.child("166").child("GhiChu").setValue("-");
        myRef.child("166").child("SoBenh").setValue("260");
        myRef.child("166").child("TenBenh").setValue("Ù tai (bó dây thần kinh)");

        myRef.child("167").child("DoLinhNghiem").setValue(0);
        myRef.child("167").child("GhiChu").setValue("Đọc số và trì niệm chú Dược Sư");
        myRef.child("167").child("SoBenh").setValue("82600");
        myRef.child("167").child("TenBenh").setValue("Đau bụng đi ngoài ra máu");

        myRef.child("168").child("DoLinhNghiem").setValue(0);
        myRef.child("168").child("GhiChu").setValue("-");
        myRef.child("168").child("SoBenh").setValue("6438200 | 64382000");
        myRef.child("168").child("TenBenh").setValue("Đau dạ dày (Trào ngược axit)");

        myRef.child("169").child("DoLinhNghiem").setValue(0);
        myRef.child("169").child("GhiChu").setValue("-");
        myRef.child("169").child("SoBenh").setValue("20060");
        myRef.child("169").child("TenBenh").setValue("Đau dạ dày (viêm xung huyết)");

        myRef.child("170").child("DoLinhNghiem").setValue(0);
        myRef.child("170").child("GhiChu").setValue("-");
        myRef.child("170").child("SoBenh").setValue("200650 | 2000650 | 200605 | 20005050 | 20006050");
        myRef.child("170").child("TenBenh").setValue("Đau khớp ngón tay");

        myRef.child("171").child("DoLinhNghiem").setValue(0);
        myRef.child("171").child("GhiChu").setValue("-");
        myRef.child("171").child("SoBenh").setValue("260 | 060");
        myRef.child("171").child("TenBenh").setValue("Đau mạn sườn");

        myRef.child("172").child("DoLinhNghiem").setValue(0);
        myRef.child("172").child("GhiChu").setValue("-");
        myRef.child("172").child("SoBenh").setValue("72,00,00.60,05");
        myRef.child("172").child("TenBenh").setValue("Đau ngang thắt lưng, cúi khom cũng đau");

        myRef.child("173").child("DoLinhNghiem").setValue(0);
        myRef.child("173").child("GhiChu").setValue("-");
        myRef.child("173").child("SoBenh").setValue("1600 | 12600 | 2600");
        myRef.child("173").child("TenBenh").setValue("Đau nửa đầu phải");

        myRef.child("174").child("DoLinhNghiem").setValue(0);
        myRef.child("174").child("GhiChu").setValue("-");
        myRef.child("174").child("SoBenh").setValue("160 | 1260");
        myRef.child("174").child("TenBenh").setValue("Đau nửa đầu trái");

        myRef.child("175").child("DoLinhNghiem").setValue(0);
        myRef.child("175").child("GhiChu").setValue("-");
        myRef.child("175").child("SoBenh").setValue("80.1206");
        myRef.child("175").child("TenBenh").setValue("Đau quanh bụng bên trái");

        myRef.child("176").child("DoLinhNghiem").setValue(0);
        myRef.child("176").child("GhiChu").setValue("-");
        myRef.child("176").child("SoBenh").setValue("72006 | 7200060");
        myRef.child("176").child("TenBenh").setValue("Đau thắt lưng");

        myRef.child("177").child("DoLinhNghiem").setValue(0);
        myRef.child("177").child("GhiChu").setValue("-");
        myRef.child("177").child("SoBenh").setValue("72006 | 720060");
        myRef.child("177").child("TenBenh").setValue("Đau thắt lưng, thoát vị đĩa đệm");

        myRef.child("178").child("DoLinhNghiem").setValue(0);
        myRef.child("178").child("GhiChu").setValue("-");
        myRef.child("178").child("SoBenh").setValue("550 | 7200650");
        myRef.child("178").child("TenBenh").setValue("Đau vai");

        myRef.child("179").child("DoLinhNghiem").setValue(0);
        myRef.child("179").child("GhiChu").setValue("-");
        myRef.child("179").child("SoBenh").setValue("650 | 7200650");
        myRef.child("179").child("TenBenh").setValue("Đau vai, mỏi cổ (thoái hóa), cánh tay, đầu gối");

        myRef.child("180").child("DoLinhNghiem").setValue(0);
        myRef.child("180").child("GhiChu").setValue("Nếu đọc thấy số nào khỏe thì dùng kèm Nam mô Dược Sư Phật");
        myRef.child("180").child("SoBenh").setValue("1260 | 2160 | 260 | 2060 | 160 | 1060");
        myRef.child("180").child("TenBenh").setValue("Đau đầu");

        myRef.child("181").child("DoLinhNghiem").setValue(0);
        myRef.child("181").child("GhiChu").setValue("-");
        myRef.child("181").child("SoBenh").setValue("260");
        myRef.child("181").child("TenBenh").setValue("Đau đầu, Ù tai");

        myRef.child("182").child("DoLinhNghiem").setValue(0);
        myRef.child("182").child("GhiChu").setValue("-");
        myRef.child("182").child("SoBenh").setValue("100065");
        myRef.child("182").child("TenBenh").setValue("Đau ống tay");

        myRef.child("183").child("DoLinhNghiem").setValue(0);
        myRef.child("183").child("GhiChu").setValue("-");
        myRef.child("183").child("SoBenh").setValue("820.60.530");
        myRef.child("183").child("TenBenh").setValue("Đầu óc minh mẫn");

        myRef.child("184").child("DoLinhNghiem").setValue(0);
        myRef.child("184").child("GhiChu").setValue("-");
        myRef.child("184").child("SoBenh").setValue("620");
        myRef.child("184").child("TenBenh").setValue("Đờm ở cổ");

        myRef.child("185").child("DoLinhNghiem").setValue(0);
        myRef.child("185").child("GhiChu").setValue("niệm danh hiệu hoặc trì chú Dược Sư");
        myRef.child("185").child("SoBenh").setValue("niệm danh hiệu hoặc trì chú Dược Sư");
        myRef.child("185").child("TenBenh").setValue("Ốm nghén");

    }
}
