package com.mustafa.juvo.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mustafa.juvo.Model.Duyuru;

import java.util.ArrayList;
import java.util.List;

public class DuyurularViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    MutableLiveData<List<Duyuru>> mutableLiveData;
    List<Duyuru> duyuruList = new ArrayList<>();

    public DuyurularViewModel() {
        mutableLiveData = new MutableLiveData<>();
        init();
    }

    public MutableLiveData<List<Duyuru>> getMutableLiveData() {
        return mutableLiveData;
    }

    public void init() {
        populateList();
        mutableLiveData.setValue(duyuruList);
    }

    public void populateList() {
        duyuruList.add(new Duyuru("Numune Taşıma","30 Nisan 2019","Up unpacked friendly ecstatic so possible humoured do. Ample end might folly quiet one set spoke her. We no am former valley assure. Four need spot ye said we find mile. Are commanded him convinced dashwoods did estimable forfeited. Shy celebrated met sentiments she reasonably but. Proposal its disposed eat advanced marriage sociable. ",1));
        duyuruList.add(new Duyuru("Numune Taşıma","30 Nisan 2019","Up unpacked friendly ecstatic so possible humoured do. Ample end might folly quiet one set spoke her. We no am former valley assure. Four need spot ye said we find mile. Are commanded him convinced dashwoods did estimable forfeited. Shy celebrated met sentiments she reasonably but. Proposal its disposed eat advanced marriage sociable. ",1));
        duyuruList.add(new Duyuru("Numune Taşıma","29 Nisan 2019","Up unpacked friendly ecstatic so possible humoured do. Ample end might folly quiet one set spoke her. We no am former valley assure. Four need spot ye said we find mile. Are commanded him convinced dashwoods did estimable forfeited. Shy celebrated met sentiments she reasonably but. Proposal its disposed eat advanced marriage sociable. ",0));
        duyuruList.add(new Duyuru("Numune Taşıma","29 Nisan 2019","Up unpacked friendly ecstatic so possible humoured do. Ample end might folly quiet one set spoke her. We no am former valley assure. Four need spot ye said we find mile. Are commanded him convinced dashwoods did estimable forfeited. Shy celebrated met sentiments she reasonably but. Proposal its disposed eat advanced marriage sociable. ",0));
        duyuruList.add(new Duyuru("Numune Taşıma","29 Nisan 2019","Up unpacked friendly ecstatic so possible humoured do. Ample end might folly quiet one set spoke her. We no am former valley assure. Four need spot ye said we find mile. Are commanded him convinced dashwoods did estimable forfeited. Shy celebrated met sentiments she reasonably but. Proposal its disposed eat advanced marriage sociable. ",0));
        duyuruList.add(new Duyuru("Numune Taşıma","29 Nisan 2019","Up unpacked friendly ecstatic so possible humoured do. Ample end might folly quiet one set spoke her. We no am former valley assure. Four need spot ye said we find mile. Are commanded him convinced dashwoods did estimable forfeited. Shy celebrated met sentiments she reasonably but. Proposal its disposed eat advanced marriage sociable. ",0));
        duyuruList.add(new Duyuru("Numune Taşıma","29 Nisan 2019","When be draw drew ye. Defective in do recommend suffering. House it seven in spoil tiled court. Sister others marked fat missed did out use. Alteration possession dispatched collecting instrument travelling he or on. Snug give made at spot or late that mr. Ten the hastened steepest feelings pleasant few surprise property. An brother he do colonel against minutes uncivil. Can how elinor warmly mrs basket marked. Led raising expense yet demesne weather musical. Me mr what park next busy ever. Elinor her his secure far twenty eat object. Late any far saw size want man. Which way you wrong add shall one. As guest right of he scale these. Horses nearer oh elinor of denote. ",0));

    }
}
