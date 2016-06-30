package sf.hotel.com.hotel_client.view.fragment.person;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sf.hotel.com.hotel_client.R;
import sf.hotel.com.hotel_client.view.custom.HotelTitleView;
import sf.hotel.com.hotel_client.view.fragment.BaseFragment;

public class MoneyFragment extends BaseFragment {
    @BindView(R.id.view_title)
    HotelTitleView mView_title;

    public static MoneyFragment newInstance() {

        Bundle args = new Bundle();

        MoneyFragment fragment = new MoneyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_money, container, false);

        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        mView_title.addLeftClick(v -> getActivity().finish());
    }

    @OnClick({R.id.account_balance, R.id.account_integral})
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.account_balance) {

        } else if (id == R.id.account_integral) {

        }
    }
}