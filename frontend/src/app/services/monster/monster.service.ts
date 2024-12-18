import { Observable, map } from 'rxjs';
import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IMonster } from '../../interfaces/monster.interface';
import { Monster } from '../../models/monster.model';

@Injectable({
  providedIn: 'root',
})
export class MonsterService {
  private readonly BASE_URL = 'http://localhost:8080/monsters/';
  private readonly http = inject(HttpClient);

  getAll(): Observable<Monster[]> {
    return this.http.get<IMonster[]>(this.BASE_URL).pipe(
      map((monsterJsonArray) => {
        return monsterJsonArray.map<Monster>((monsterJson) =>
          Monster.fromJson(monsterJson)
        );
      })
    );
  }

  get(id: number): Observable<Monster> {
    return this.http
      .get<IMonster>(this.BASE_URL + id + '/')
      .pipe(map((monsterJson) => Monster.fromJson(monsterJson)));
  }

  add(monster: Monster): Observable<Monster> {
    return this.http
      .post<IMonster>(this.BASE_URL, monster.toJson())
      .pipe(map((monsterJson) => Monster.fromJson(monsterJson)));
  }

  update(monster: Monster): Observable<Monster> {
    return this.http
      .put<IMonster>(this.BASE_URL + monster.id + '/', monster.toJson())
      .pipe(map((monsterJson) => Monster.fromJson(monsterJson)));
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(this.BASE_URL + id + '/');
  }
}
