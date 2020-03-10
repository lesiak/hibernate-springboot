package com.example.sandbox.hibernatespringboot.repo.group;

import com.example.sandbox.hibernatespringboot.model.group.Point;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointRepository extends JpaRepository<Point, Point.PointIdentity> {
}
