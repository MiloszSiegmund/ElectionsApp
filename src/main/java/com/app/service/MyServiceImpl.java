package com.app.service;

import com.app.dao.CandidateDao;
import com.app.dao.CityDao;
import com.app.dao.ConstituencyDao;
import com.app.dao.VoterDao;
import com.app.dto.CandidateDto;
import com.app.dto.CityDto;
import com.app.dto.ConstituencyDto;
import com.app.dto.VoterDto;
import com.app.model.Candidate;
import com.app.model.City;
import com.app.model.Constituency;
import com.app.model.Voter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyServiceImpl implements MyService {

    private CandidateDao candidateDao;
    private CityDao cityDao;
    private ConstituencyDao constituencyDao;
    private VoterDao voterDao;

    public MyServiceImpl(CandidateDao candidateDao, CityDao cityDao, ConstituencyDao constituencyDao, VoterDao voterDao) {
        this.candidateDao = candidateDao;
        this.cityDao = cityDao;
        this.constituencyDao = constituencyDao;
        this.voterDao = voterDao;
    }

    @Override
    public void saveCandidate(Candidate candidate) {
        candidateDao.save(candidate);

    }

    @Override
    public void modifyCandidate(Candidate candidate) {
        candidateDao.save(candidate);
    }

    @Override
    public void deleteCandidate(Long id) {
        Candidate candidate = candidateDao.getOne(id);
        candidateDao.delete(candidate);


    }

    @Override
    public Optional<Candidate> getCandidateById(Long id) {
        Candidate candidate = candidateDao.getOne(id);
        if (candidate.getName() != null) {
            candidate.getName().length();
        }
        return Optional.ofNullable(candidate);
    }

    @Override
    public List<CandidateDto> getAllCandidates() {
        return null;
    }

    @Override
    public void saveCity(City city) {

    }

    @Override
    public void modifyCity(City city) {

    }

    @Override
    public void deleteCity(Long id) {

    }

    @Override
    public Optional<City> getCityById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<CityDto> getAllCities() {
        return null;
    }

    @Override
    public void saveConstituency(Constituency constituency) {

    }

    @Override
    public void modifyConstituency(Constituency constituency) {

    }

    @Override
    public void deleteConstituency(Constituency constituency) {

    }

    @Override
    public Optional<Constituency> getConstituencyByIdl(Long id) {
        return Optional.empty();
    }

    @Override
    public List<ConstituencyDto> getAllConstituencies() {
        return null;
    }

    @Override
    public void saveVoter(Voter voter) {

    }

    @Override
    public void modifyVoter(Voter voter) {

    }

    @Override
    public void deleteVoter(Long id) {

    }

    @Override
    public Optional<Voter> getVoterById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<VoterDto> getAllVoters() {
        return null;
    }
}
