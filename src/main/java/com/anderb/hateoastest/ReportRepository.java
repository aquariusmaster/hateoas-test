package com.anderb.hateoastest;

import com.anderb.hateoastest.model.Report;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReportRepository extends PagingAndSortingRepository<Report, Long> {
}
