package com.app.service;

import com.app.dto.CandidateDto;
import com.app.dto.CityDto;
import com.app.dto.ConstituencyDto;
import com.app.dto.VoterDto;
import com.app.model.Candidate;
import com.app.model.City;
import com.app.model.Constituency;
import com.app.model.Voter;

import java.util.List;
import java.util.Optional;

public interface MyService {

    void saveCandidate (Candidate candidate);
    void modifyCandidate(Candidate candidate);
    void deleteCandidate(Long id);
    Optional<Candidate> getCandidateById(Long id);
    List<CandidateDto> getAllCandidates();

    void saveCity(City city);
    void modifyCity(City city);
    void deleteCity(Long id);
    Optional<City> getCityById(Long id);
    List<CityDto> getAllCities();

    void saveConstituency(Constituency constituency);
    void modifyConstituency(Constituency constituency);
    void deleteConstituency(Long id);
    Optional<Constituency> getConstituencyByIdl(Long id);
    List<ConstituencyDto> getAllConstituencies();

    void saveVoter(Voter voter);
    void modifyVoter(Voter voter);
    void deleteVoter(Long id);
    Optional<Voter> getVoterById(Long id);
    List<VoterDto> getAllVoters();
}
