import { Component, ViewChild } from '@angular/core';
import { Computer } from 'src/app/model/computer.model';
import { ComputersService } from 'src/app/services/computers.service';
import { MatTableDataSource } from '@angular/material/table';
import { LiveAnnouncer } from '@angular/cdk/a11y';
import { MatSort, Sort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';

@Component({
  selector: 'app-computer-list',
  templateUrl: './computer-list.component.html',
  styleUrls: ['./computer-list.component.css'],
})
export class ComputerListComponent {
  dataSource = new MatTableDataSource<Computer>();
  displayedColumns: string[] = [
    'deviceId',
    'domainName',
    'manufacturer',
    'serialNumber',
    'productNumber',
    'description',
    'computerType',
    'actions',
  ];

  constructor(
    private computersService: ComputersService,
    private _liveAnnouncer: LiveAnnouncer
  ) {}

  @ViewChild(MatSort) sort!: MatSort;
  @ViewChild(MatPaginator) paginator: any = MatPaginator;

  ngOnInit(): void {
    this.getComputersList();
  }

  getComputersList(): void {
    this.computersService.getComputers().subscribe(
      (response) => {
        this.dataSource = new MatTableDataSource<Computer>(response);
        this.dataSource.sort = this.sort;
      },
      (error) => {
        console.log(error);
      }
    );
  }

  announceSortChange(sortState: Sort) {
    if (sortState.direction) {
      this._liveAnnouncer.announce(`Sorted ${sortState.direction}ending`);
    } else {
      this._liveAnnouncer.announce('Sorting cleared');
    }
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}
