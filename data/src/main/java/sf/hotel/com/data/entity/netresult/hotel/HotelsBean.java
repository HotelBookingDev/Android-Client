package sf.hotel.com.data.entity.netresult.hotel;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * @author MZ
 * @email sanfenruxi1@163.com
 * @date 16/7/4.
 */
public class HotelsBean implements Parcelable{

    /**
     * hotel_imgs : []
     * address : address
     * introduce : 一家酒店
     * id : 1
     * city : 1234
     * contact_phone : 15726814574
     * name : 酒店名字
     * hotel_houses : [{"hotel":1,"checked":true,"name":"商务大床","house_imgs":[],"housePackages":[{"breakfast":1,"states":[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],"detail":"3333","need_point":123,"id":"c4080588-1ef1-4b16-85f5-741f538c9f0e","front_price":22},{"breakfast":1,"states":[],"detail":"","need_point":123,"id":"92ebd074-de5c-4bef-b4c4-ec7b72ee2631","front_price":123},{"breakfast":1,"states":[],"detail":"","need_point":123,"id":"6871a171-bb53-4048-910d-6014615e671e","front_price":123},{"breakfast":1,"states":[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],"detail":"zao","need_point":20,"id":"4d587e07-8704-4048-b59f-41067528e2c0","front_price":130},{"breakfast":1,"states":[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],"detail":"dddd","need_point":12,"id":"100f5982-cfca-4c80-a7cb-7f0b229a06bb","front_price":340}],"id":1,"enabled":true},{"hotel":1,"checked":false,"name":"123","house_imgs":[],"housePackages":[{"breakfast":1,"states":[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],"detail":"","need_point":20,"id":"49d5dd08-199e-4002-970a-6860b7c301c2","front_price":100}],"id":4,"enabled":false},{"hotel":1,"checked":false,"name":"123","house_imgs":[],"housePackages":[{"breakfast":1,"states":[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],"detail":"","need_point":20,"id":"fabcd10a-3496-4dec-8547-724d8b7ee57b","front_price":100}],"id":5,"enabled":false},{"hotel":1,"checked":false,"name":"123","house_imgs":[],"housePackages":[{"breakfast":1,"states":[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],"detail":"","need_point":20,"id":"b91884cc-1817-4e11-960f-2540acf761f0","front_price":100}],"id":6,"enabled":false},{"hotel":1,"checked":false,"name":"123","house_imgs":[],"housePackages":[{"breakfast":1,"states":[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],"detail":"","need_point":20,"id":"d8b159a4-ba0c-4a93-943b-cd9a8bacc2fb","front_price":100},{"breakfast":1,"states":[],"detail":"","need_point":123,"id":"855e0979-987d-49ec-a791-3a38f14e8ba1","front_price":123},{"breakfast":1,"states":[],"detail":"","need_point":123,"id":"66254f39-50b7-4544-b42d-6e2d1913dbe7","front_price":123},{"breakfast":1,"states":[],"detail":"","need_point":123,"id":"3cae41af-0343-43fb-a7bd-4aa69fc12dd0","front_price":123},{"breakfast":1,"states":[],"detail":"","need_point":123,"id":"2ed142c6-870e-4a3f-b16b-938ea5e04673","front_price":123}],"id":7,"enabled":false},{"hotel":1,"checked":false,"name":"123","house_imgs":[],"housePackages":[{"breakfast":1,"states":[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],"detail":"","need_point":20,"id":"def0509e-4360-4a18-91e2-b25ac87ca4fd","front_price":100}],"id":21,"enabled":false},{"hotel":1,"checked":false,"name":"123","house_imgs":[],"housePackages":[{"breakfast":1,"states":[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],"detail":"","need_point":20,"id":"0d21d002-ce4e-4c0f-a7ff-4ae1807d3f39","front_price":100}],"id":22,"enabled":false},{"hotel":1,"checked":false,"name":"123","house_imgs":[],"housePackages":[{"breakfast":1,"states":[],"detail":"","need_point":20,"id":"59ee8a37-3fd4-44d2-ae47-54d6befb0bfa","front_price":100}],"id":23,"enabled":false},{"hotel":1,"checked":false,"name":"\u201cnb\"","house_imgs":[],"housePackages":[{"breakfast":1,"states":[],"detail":"","need_point":123,"id":"f821fa4c-6920-4b52-864e-96037e3f4709","front_price":123}],"id":24,"enabled":false},{"hotel":1,"checked":false,"name":"123","house_imgs":[],"housePackages":[{"breakfast":1,"states":[],"detail":"","need_point":20,"id":"30dc1c82-9c9a-4cf0-bcbe-7fe214e437d1","front_price":100}],"id":25,"enabled":false},{"hotel":1,"checked":false,"name":"\u201cnb\"","house_imgs":[],"housePackages":[{"breakfast":1,"states":[],"detail":"","need_point":1,"id":"ec7c76a2-b129-43f3-b34a-99f45d5ba98a","front_price":1}],"id":30,"enabled":false},{"hotel":1,"checked":false,"name":"豪华","house_imgs":[],"housePackages":[{"breakfast":1,"states":[],"detail":"","need_point":1,"id":"ac406ddd-c9ed-42fa-b066-06acc2253616","front_price":1}],"id":35,"enabled":false}]
     * types : [{"id":1,"name":"商务大床"},{"id":4,"name":"123"},{"id":5,"name":"123"},{"id":6,"name":"123"},{"id":7,"name":"123"},{"id":21,"name":"123"},{"id":22,"name":"123"},{"id":23,"name":"123"},{"id":24,"name":"\u201cnb\""},{"id":25,"name":"123"},{"id":30,"name":"\u201cnb\""},{"id":35,"name":"豪华"}]
     */

    private String address;
    private String introduce;
    private int id;
    private int city;
    private String contact_phone;
    private String name;
    private List<String> hotel_imgs;
    /**
     * hotel : 1
     * checked : true
     * name : 商务大床
     * house_imgs : []
     * housePackages : [{"breakfast":1,"states":[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],"detail":"3333","need_point":123,"id":"c4080588-1ef1-4b16-85f5-741f538c9f0e","front_price":22},{"breakfast":1,"states":[],"detail":"","need_point":123,"id":"92ebd074-de5c-4bef-b4c4-ec7b72ee2631","front_price":123},{"breakfast":1,"states":[],"detail":"","need_point":123,"id":"6871a171-bb53-4048-910d-6014615e671e","front_price":123},{"breakfast":1,"states":[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],"detail":"zao","need_point":20,"id":"4d587e07-8704-4048-b59f-41067528e2c0","front_price":130},{"breakfast":1,"states":[1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1],"detail":"dddd","need_point":12,"id":"100f5982-cfca-4c80-a7cb-7f0b229a06bb","front_price":340}]
     * id : 1
     * enabled : true
     */

    private List<HotelHousesBean> hotel_houses;
    /**
     * id : 1
     * name : 商务大床
     */

    private List<TypesBean> types;

    protected HotelsBean(Parcel in) {
        address = in.readString();
        introduce = in.readString();
        id = in.readInt();
        city = in.readInt();
        contact_phone = in.readString();
        name = in.readString();
        hotel_imgs = in.createStringArrayList();
        hotel_houses = in.createTypedArrayList(HotelHousesBean.CREATOR);
        types = in.createTypedArrayList(TypesBean.CREATOR);
    }

    public static final Creator<HotelsBean> CREATOR = new Creator<HotelsBean>() {
        @Override
        public HotelsBean createFromParcel(Parcel in) {
            return new HotelsBean(in);
        }

        @Override
        public HotelsBean[] newArray(int size) {
            return new HotelsBean[size];
        }
    };

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public String getContact_phone() {
        return contact_phone;
    }

    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getHotel_imgs() {
        return hotel_imgs;
    }

    public void setHotel_imgs(List<String> hotel_imgs) {
        this.hotel_imgs = hotel_imgs;
    }

    public List<HotelHousesBean> getHotel_houses() {
        return hotel_houses;
    }

    public void setHotel_houses(List<HotelHousesBean> hotel_houses) {
        this.hotel_houses = hotel_houses;
    }

    public List<TypesBean> getTypes() {
        return types;
    }

    public void setTypes(List<TypesBean> types) {
        this.types = types;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(address);
        dest.writeString(introduce);
        dest.writeInt(id);
        dest.writeInt(city);
        dest.writeString(contact_phone);
        dest.writeString(name);
        dest.writeStringList(hotel_imgs);
        dest.writeTypedList(hotel_houses);
        dest.writeTypedList(types);
    }
}